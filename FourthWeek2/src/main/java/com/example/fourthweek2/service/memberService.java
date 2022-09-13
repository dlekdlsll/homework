package com.example.fourthweek2.service;

import com.example.fourthweek2.repository.memberRepository;
import com.example.fourthweek2.store.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class memberService {
    @Autowired
    private memberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }
}
