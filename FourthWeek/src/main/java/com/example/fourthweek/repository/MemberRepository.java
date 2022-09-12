package com.example.fourthweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fourthweek.store.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
