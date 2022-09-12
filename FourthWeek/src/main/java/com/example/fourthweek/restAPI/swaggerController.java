package com.example.fourthweek.restAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fourthweek.service.memberService;
import com.example.fourthweek.store.Member;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class swaggerController {
	
	@Autowired
	private memberService service;
	ResponseEntity<?> entity = null;
	
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
//	@GetMapping(value="/register")
//	public ResponseEntity<?> registerMember(String name,String address, String phoneNumber) {
//		Member member = new Member();
//		member.setName(name);
//		member.setAddress(address);
//		member.setPhoneNumber(phoneNumber);
//		try {
//			service.register(member);
//			return ResponseEntity.status(HttpStatus.OK).body("success");
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
//		}
//	}
	
//	@ApiOperation(value="회원 목록", notes="회원 목록")
//	@GetMapping(value="/getList")
//	public List<Member> getList() {
//		return service.getList();
//	}
	
}