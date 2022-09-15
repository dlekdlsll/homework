package com.example.fourthweek2.service;

import com.example.fourthweek2.store.Member;
import com.example.fourthweek2.store.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepo extends JpaRepository<Member, MemberId> {

}