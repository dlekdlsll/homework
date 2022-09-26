package com.example.fourthweek2.service;

import com.example.fourthweek2.store.Member;
import com.example.fourthweek2.store.MemberId;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemberService{
    private MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public void save(Member member) {
        if (memberRepo.findAll().stream().filter(r -> r.getPhoneNumber() == member.getPhoneNumber())) {

        }
        memberRepo.save(member);
    }

    public List<Member> findAll() {
        return memberRepo.findAll();
    }


    public Member findById(MemberId memberId) {
        return memberRepo.findById(memberId).get();
    }

    public void deleteById(MemberId memberId) {
        memberRepo.deleteById(memberId);
    }
}