package com.example.fourthweek2.repository;

import com.example.fourthweek2.store.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface memberRepository extends JpaRepository<Member, Long> {
}
