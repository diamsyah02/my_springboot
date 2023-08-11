package com.belajar.myspringboot.modules.member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.myspringboot.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    MemberService memberService;
    
    @GetMapping
    public ResponseEntity<Response> findAll() {
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("Get data member success");
        response.setData(memberService.findAll(null));
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> findById(@PathVariable("id") Integer id) {
        Member member = memberService.findById(id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("Get data member with id "+id+" success");
        response.setData(member);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Member member) {
        Integer created = memberService.create(member);
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("Insert data member success");
        response.setData(created);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable("id") Integer id, @RequestBody Member member) {
        Integer updated = memberService.update(id, member);
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("Update data member with id "+id+" success");
        response.setData(updated);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Integer id) {
        Integer deleted = memberService.delete(id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setMessage("Delete data member with id "+id+" success");
        response.setData(deleted);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}