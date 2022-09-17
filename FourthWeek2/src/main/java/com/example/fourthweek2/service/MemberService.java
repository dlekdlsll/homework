package com.example.fourthweek2.service;

import org.springframework.stereotype.Service;


@Service
public class MemberService {private MemberRepo memberRepo;

    protected MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

}