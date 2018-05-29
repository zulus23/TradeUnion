package ru.zhukov.tradeunion.web.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository  extends JpaRepository<Member,String> {

      public List<Member> findAllByEnterprise(String department);
}
