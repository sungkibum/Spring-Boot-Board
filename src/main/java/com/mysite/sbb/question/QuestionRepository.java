package com.mysite.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    //인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속
        //Question 엔티티로 리포지터리를 생성한다는 의미, 기본키가 Integer
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subject, String content);

    List<Question> findBySubjectLike(String subject);

    Integer id(Integer id);
    //위의 메서드를 선언만 하고 구현하지 않았는데 실행이 되는 이유
    //JPA에 리포지터리의 메서드명을 분석하여 쿼리를 만들고 실행하는 기능이 있기 때문에 가능
    //findBy + 엔티티의 속성명과 같은 리포지터리의 메서드를 작성하면 입력한 속성의 값으로 데이터 조회 가능

    Page<Question> findAll(Pageable pageable);

}
