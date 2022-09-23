package com.example.fourthweek2.service;

import org.springframework.stereotype.Service;


@Service
public class MemberService {
    private MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }


}