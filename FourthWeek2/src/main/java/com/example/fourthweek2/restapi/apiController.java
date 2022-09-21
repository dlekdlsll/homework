package com.example.fourthweek2.restapi;

import com.example.fourthweek2.service.MemberRepo;
import com.example.fourthweek2.store.Member;
import com.example.fourthweek2.store.MemberData;
import com.example.fourthweek2.store.MemberId;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class apiController {

    private final MemberRepo service;

    ResponseEntity<?> entity = null;

    @ApiOperation(value="회원 등록", notes="회원 등록")
    @PostMapping(value="/register")
    public ResponseEntity<?> registerMember(@RequestBody MemberData data) {
        try {
            if(data != null) {
                MemberId memberId = new MemberId();
                Member member = new Member();
                member.setId(memberId);
                member.setName(data.getName());
                member.setAddress(data.getAddress());
                member.setPhoneNumber(data.getPhoneNumber());
                service.save(member);
                entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
            }else {
                entity = new ResponseEntity<String>("NO DATA", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @ApiOperation(value="회원 내역", notes="회원 내역")
    @GetMapping(value = "/read")
    public Member readMember() {
        Member member = null;
        try {
            if (service.findAll().size() != 0) {
                member = (Member) service.findAll();
                entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
            } else {
                entity = new ResponseEntity<String>("NO DATA", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return member;
    }
}
