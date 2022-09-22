package com.example.fourthweek2.restapi;

import com.example.fourthweek2.service.MemberRepo;
import com.example.fourthweek2.store.Member;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
