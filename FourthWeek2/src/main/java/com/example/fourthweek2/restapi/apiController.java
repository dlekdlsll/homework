package com.example.fourthweek2.restapi;

import com.example.fourthweek2.service.MemberRepo;
import com.example.fourthweek2.store.Member;
import com.example.fourthweek2.store.MemberId;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class apiController {

    private final MemberRepo service;

    ResponseEntity<?> entity = null;

    @ApiOperation(value="회원 등록", notes="회원 등록")
    @PostMapping(value="/register")
    public ResponseEntity<?> registerMember(@RequestParam String name, @RequestParam String phoneNumber, @RequestParam String address) {
        try {
            if(name != null & phoneNumber != null & address != null) {
                Member member = new Member(name, phoneNumber, address);
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
    public List<Member> readMember() {
        try {
            if (service.findAll().size() != 0) {
                entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
            } else {
                entity = new ResponseEntity<String>("NO DATA", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return service.findAll();
    }

    @ApiOperation(value="회원 내역 Key로 검색", notes="회원 내역 Key로 검색")
    @GetMapping(value = "/readKey")
    public Member readMemberByKey(@RequestParam(required = false) String uid, @RequestParam(required = false) String regdate) {
        List<Member> list = service.findAll();
        list = list.stream().filter(record -> record.getId().getId() == uid || record.getId().getRegdate() == regdate).distinct().collect(Collectors.toList());
        Member member = null;
        try {
            if (uid != null || regdate != null) {
                member = (Member) list.stream().filter(record -> record.getId().getId() == uid || record.getId().getRegdate() == regdate);
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
