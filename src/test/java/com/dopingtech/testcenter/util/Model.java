package com.dopingtech.testcenter.util;

import com.dopingtech.testcenter.domain.model.Question;
import com.dopingtech.testcenter.domain.model.StudentTest;
import com.dopingtech.testcenter.domain.model.Test;

public class Model {

    public static StudentTest createStudentTest(Long testId, Long questionId) {
        StudentTest studentTest = new StudentTest();
        Test test = new Test();
        test.setId(testId);
        studentTest.setTest(test);
        Question question = new Question();
        question.setId(questionId);
        studentTest.setQuestion(question);
        return studentTest;
    }
}
