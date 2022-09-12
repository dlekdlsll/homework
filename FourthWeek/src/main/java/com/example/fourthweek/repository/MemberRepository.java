package com.example.fourthweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fourthweek.store.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
