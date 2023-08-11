package com.belajar.myspringboot.modules.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query(value = "SELECT * FROM member", nativeQuery = true)
    List<Member> findAll();

    @Query(value = "SELECT * FROM Member m WHERE m.id=:id", nativeQuery = true)
    Member find(@Param("id") Integer id);

    @Modifying
    @Query(value = "INSERT INTO member (nama_member, email, no_hp) VALUES (:nama_member, :email, :no_hp)", nativeQuery = true)
    Integer create(
        @Param("nama_member") String nama_member,
        @Param("email") String email,
        @Param("no_hp") String no_hp
    );

    @Modifying
    @Query(value = "UPDATE member SET nama_member = :nama_member, email = :email, no_hp = :no_hp WHERE id = :id", nativeQuery = true)
    Integer update(
        @Param("id") Integer id,
        @Param("nama_member") String nama_member,
        @Param("email") String email,
        @Param("no_hp") String no_hp
    );

    @Modifying
    @Query(value = "DELETE FROM member WHERE id=:id", nativeQuery = true)
    Integer delete(@Param("id") Integer id);
}
