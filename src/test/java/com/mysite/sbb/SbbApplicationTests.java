package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq = questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		List<Answer> answerList = q.getAnswerList();

		//답변의 리스트의 길이를 테스트, 답변리스트의 길이가 1이므로 답변리스트의 첫번째 요소의 내용을 테스트
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

		//답변 객체에 답변리스트의 첫번째 값 대입, 생성한 객체의 컬럼 중 질문으로 테스트(위에서 가져온 질문 객체(q)와
		//답변 객체에서의 질문은 외래키이므로 같아야 한다.
		Answer a = answerList.get(0);
		assertEquals(q, a.getQuestion());
	}
}