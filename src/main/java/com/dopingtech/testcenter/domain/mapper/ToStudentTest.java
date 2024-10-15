package com.dopingtech.testcenter.domain.mapper;

import com.dopingtech.testcenter.domain.dto.request.StudentTestRequest;
import com.dopingtech.testcenter.domain.model.*;

import java.time.Instant;
import java.util.List;

public class ToStudentTest {

    public static List<StudentTest> convert(StudentTestRequest studentTestRequest) {
        return studentTestRequest.getQuestionAndAnswers().stream().map(questionAnswerRequest ->
            StudentTest.builder()
                    .test(Test.builder().id(studentTestRequest.getTestId()).build())
                    .student(Student.builder().id(studentTestRequest.getStudentId()).build())
                    .answer(QuestionChoice.builder().id(questionAnswerRequest.getAnswerId()).build())
                    .question(Question.builder().id(questionAnswerRequest.getQuestionId()).build())
                    .createdAt(Instant.now())
                    .build()
        ).toList();
    }
}
