package com.belajar.myspringboot.modules.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.belajar.myspringboot.utils.Response;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    
    public Response findAll(Pageable pageable) {
        List<Member> data = memberRepository.findAll();
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("Get data member success");
        response.setData(data);
        return response;
    }

    public Response findById(Integer id) {
        Member data = memberRepository.find(id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("Get data member success");
        response.setData(data);
        return response;
    }

    @Transactional
    public Response create(Member member) {
        Integer data = memberRepository.create(
            member.getNama_member(),
            member.getEmail(),
            member.getNo_hp()
        );
        Response response = new Response();
        if(data == 1) {
            response.setStatusCode(200);
            response.setMessage("Insert data member success");
        } else {
            response.setStatusCode(400);
            response.setMessage("Insert data member failed");
        }
        response.setData(data);
        return response;
    }

    @Transactional
    public Response update(Integer id, Member member) {
        Integer data = memberRepository.update(
            id,
            member.getNama_member(),
            member.getEmail(),
            member.getNo_hp()
        );
        Response response = new Response();
        if(data == 1) {
            response.setStatusCode(200);
            response.setMessage("Update data member with id "+id+" success");
        } else {
            response.setStatusCode(400);
            response.setMessage("Update data member with id "+id+" failed");
        }
        response.setData(data);
        return response;
    }

    @Transactional
    public Response delete(Integer id) {
        Integer data = memberRepository.delete(id);
        Response response = new Response();
        if(data == 1) {
            response.setStatusCode(200);
            response.setMessage("Delete data member with id "+id+" success");
        } else {
            response.setStatusCode(400);
            response.setMessage("Delete data member with id "+id+" failed");
        }
        response.setData(data);
        return response;
    }
}