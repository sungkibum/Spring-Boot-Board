package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {

	@Autowired	//의존성 주입(스프링이 객체를 대신 생성하여 주입하는 기법)
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		List<Question> oq = questionRepository.findBySubjectLike("sbb%");
		Question q = oq.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}