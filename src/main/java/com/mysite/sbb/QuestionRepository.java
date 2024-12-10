package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
        //인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속
        //Question 엔티티로 리포지터리를 생성한다는 의미, 기본키가 Integer
}
