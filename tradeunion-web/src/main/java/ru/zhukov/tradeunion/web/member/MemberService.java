package ru.zhukov.tradeunion.web.member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Optional<Member> findMember(String value); //поиск по ...???
    List<Member> listMembersByEnterprise(String enterprise);
}