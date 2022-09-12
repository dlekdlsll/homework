package com.example.fourthweek.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fourthweek.repository.MemberRepository;
import com.example.fourthweek.store.Member;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class memberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void save(Member member) {
		memberRepository.save(member);
	}
	
//	private memberMapper mapper;
//	
//	public void register(Member member) {
//		member.setId(UUID.randomUUID().toString());
//		mapper.register(member);
//	}
//	
//	public List<Member> getList() {
//		return mapper.getList();
//	}
//	
//	public Member read(String id) {
//		return mapper.read(id);
//	}
//	
//	public boolean delete(String id) {
//		return mapper.delete(id);
//	}
//	
//	public boolean update(String id, Member member) {
//		return (mapper.update(id, member)==true);
//	}
}
