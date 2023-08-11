package com.belajar.myspringboot.modules.member;

import com.belajar.myspringboot.modules.member.Member;
import com.belajar.myspringboot.modules.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    
    public List<Member> findAll(Pageable pageable) {
        return memberRepository.findAll();
    }

    public Member findById(Integer id) {
        return memberRepository.find(id);
    }

    @Transactional
    public Integer create(Member member) {
        return memberRepository.create(
            member.getNama_member(),
            member.getEmail(),
            member.getNo_hp()
        );
    }

    @Transactional
    public Integer update(Integer id, Member member) {
        return memberRepository.update(
            id,
            member.getNama_member(),
            member.getEmail(),
            member.getNo_hp()
        );
    }

    @Transactional
    public Integer delete(Integer id) {
        return memberRepository.delete(id);
    }
}