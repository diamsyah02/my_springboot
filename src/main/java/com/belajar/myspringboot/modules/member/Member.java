package com.belajar.myspringboot.modules.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Member.
 */
@Entity
@Setter
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama_member")
    private String nama_member;
    @Column(name = "email")
    private String email;
    @Column(name = "no_hp")
    private String no_hp;
}