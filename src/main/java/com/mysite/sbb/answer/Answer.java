package com.mysite.sbb.answer;


import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    LocalDateTime createDate;

    @ManyToOne  //질문 하나당 답변은 여러개, 답변 엔티티의 question 속성과 질문 엔티티가 서로 연결(외래키 관계 생성)
    private Question question;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;    //Set 자료형은 서로 중복되지 않는다
}
