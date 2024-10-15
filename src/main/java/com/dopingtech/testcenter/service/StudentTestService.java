package com.dopingtech.testcenter.service;

import com.dopingtech.testcenter.domain.dto.request.StudentTestRequest;
import com.dopingtech.testcenter.domain.model.StudentTest;

import java.util.List;

public interface StudentTestService {

    void save(StudentTestRequest testAnswers);

    List<StudentTest> getStudentTests(Long studentId);

    List<StudentTest> getStudentTest(Long studentId, Long testId);
}
