package com.example.fourthweek2.restapi;

import com.example.fourthweek2.service.MemberRepo;
import com.example.fourthweek2.service.MemberService;
import com.example.fourthweek2.store.Member;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class apiController {

    @Autowired
    private MemberRepo service;

    ResponseEntity<?> entity = null;

    @ApiOperation(value="회원 등록", notes="회원 등록")
    @GetMapping(value="/register")
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
}
