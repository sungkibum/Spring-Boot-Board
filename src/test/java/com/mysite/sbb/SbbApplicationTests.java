package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

	@Autowired    //의존성 주입(스프링이 객체를 대신 생성하여 주입하는 기법)
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Optional<Answer> oa = answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals("네 자동으로 생성됩니다.", a.getContent());
	}
}