package ru.zhukov.tradeunion.member;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Optional<Member> findMember(String value) {
        return Optional.empty();
    }
}
