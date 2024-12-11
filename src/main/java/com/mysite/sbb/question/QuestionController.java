package com.mysite.sbb.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {

    @ResponseBody
    @GetMapping("/question/list")
    public String questionList() {
        return "questionList";
    }
}
