package ru.zhukov.tradeunion.web.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/members/")
    public ResponseEntity<List<Member>> listMembers(String enterprise){
        List<Member> members = memberService.listMembersByEnterprise("Готэк");

        return Optional.ofNullable(members)
                       .filter(e -> e.size() > 0)
                       .map( r -> new ResponseEntity<List<Member>>(members,HttpStatus.OK))
                       .orElseGet(()-> new ResponseEntity(HttpStatus.NOT_FOUND));
    }


}
