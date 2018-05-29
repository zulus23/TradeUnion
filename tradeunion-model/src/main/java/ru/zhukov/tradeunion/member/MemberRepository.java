package ru.zhukov.tradeunion.member;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zhukov.tradeunion.domain.Member;

import java.util.List;

public interface MemberRepository  extends JpaRepository<Member,String> {

      public List<Member> findAllByEnterprise(String department);
}
