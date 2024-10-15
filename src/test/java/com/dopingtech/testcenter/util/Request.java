package com.dopingtech.testcenter.util;

import com.dopingtech.testcenter.domain.dto.request.QuestionAnswerRequest;
import com.dopingtech.testcenter.domain.dto.request.StudentTestRequest;

import java.util.Arrays;

public class Request {

    public static StudentTestRequest createStudentTestRequest(Long studentId, Long testId, Long questionId) {
        StudentTestRequest testRequest = new StudentTestRequest();
        testRequest.setStudentId(studentId);
        testRequest.setTestId(testId);
        QuestionAnswerRequest questionAnswerRequest = new QuestionAnswerRequest();
        questionAnswerRequest.setQuestionId(questionId);
        testRequest.setQuestionAndAnswers(Arrays.asList(questionAnswerRequest));
        return testRequest;
    }
}
