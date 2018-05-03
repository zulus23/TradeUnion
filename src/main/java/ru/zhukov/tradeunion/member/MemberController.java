package ru.zhukov.tradeunion.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/{enterprise}/members/")
    public List<Member> listMembers(@PathVariable String enterprise){
        return memberService.listMembersByEnterprise(enterprise);
    }


}