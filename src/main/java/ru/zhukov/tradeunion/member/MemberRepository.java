package ru.zhukov.tradeunion.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository  extends JpaRepository<Member,String> {

      public List<Member> findAllByEnterprise(String department);
}
