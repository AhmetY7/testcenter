package com.dopingtech.testcenter.domain.mapper;

import com.dopingtech.testcenter.domain.dto.response.QuestionChoiceResponse;
import com.dopingtech.testcenter.domain.dto.response.StudentTestResponse;
import com.dopingtech.testcenter.domain.model.StudentTest;

import java.util.List;

public class ToStudentTestResponse {

    public static StudentTestResponse convert(List<StudentTest> studentTests) {
        var rightAnswers = studentTests.stream().filter(studentTest -> studentTest.getAnswer().getIsRightAnswer()).count();
        var totalNumberOfQuestion = studentTests.getFirst().getTest().getQuestions().size();
        return StudentTestResponse.builder()
                .student(studentTests.getFirst().getStudent())
                .test(studentTests.getLast().getTest())
                .answers(studentTests.stream().map(studentTest -> QuestionChoiceResponse.builder()
                        .id(studentTest.getAnswer().getId())
                        .choiceSymbol(studentTest.getAnswer().getChoiceSymbol())
                        .question(studentTest.getQuestion())
                        .choice(studentTest.getAnswer().getChoice())
                        .isRightAnswer(studentTest.getAnswer().getIsRightAnswer())
                        .build()).toList())
                .rightAnswers((int) rightAnswers)
                .wrongAnswers((int) (totalNumberOfQuestion-rightAnswers))
                .totalNumberOfQuestions(totalNumberOfQuestion)
                .build();
    }
}
