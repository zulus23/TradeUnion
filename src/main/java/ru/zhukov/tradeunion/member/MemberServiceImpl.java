package ru.zhukov.tradeunion.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;
    @Override
    public Optional<Member> findMember(String value) {

        return Optional.empty();
    }
    public List<Member> listMembersByEnterprise(String enterprise){
        return repository.findAllByEnterprise(enterprise);
    }

}
