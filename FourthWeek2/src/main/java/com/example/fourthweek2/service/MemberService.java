package com.example.fourthweek2.service;

import org.springframework.stereotype.Service;


@Service
public abstract class MemberService implements MemberRepo{
    private final MemberRepo service;

    protected MemberService(MemberRepo memberRepo) {
        this.service = memberRepo;
    }
}