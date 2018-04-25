package ru.zhukov.tradeunion.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member,String> {


}
