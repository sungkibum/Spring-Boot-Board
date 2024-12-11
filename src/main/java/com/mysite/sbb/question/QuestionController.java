package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor    //final이 붙은 속성을 포함하는 생성자를 자동으로 만들어주는 역할
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

//    @ResponseBody     이젠 템플릿을 사용하기 때문에 필요없음
    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
