package com.mysite.sbb.answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    //AnswerRepository 인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속
    //Answer 엔티티로 리포지터리 생성, 기본키 Integer
}
