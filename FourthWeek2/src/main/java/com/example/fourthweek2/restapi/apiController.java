package com.example.fourthweek2.restapi;

import com.example.fourthweek2.service.MemberRepo;
import com.example.fourthweek2.store.Member;
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

    @GetMapping(value="/hello")
    public String hello1() {
        return "hello";
    }

    @ApiOperation(value="회원 등록", notes="회원 등록")
    @PostMapping(value="/register")
    public ResponseEntity<?> registerMember(@RequestBody Member member) {
        try {
            if(member != null) {
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
    public ResponseEntity<?> readMember() {
        try {
            if (service.findAll().size() != 0) {
                service.findAll();
                entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
            } else {
                entity = new ResponseEntity<String>("NO DATA", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
