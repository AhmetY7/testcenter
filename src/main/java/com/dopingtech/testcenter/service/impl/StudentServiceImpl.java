package com.dopingtech.testcenter.service.impl;

import com.dopingtech.testcenter.domain.exception.ApiRequestException;
import com.dopingtech.testcenter.domain.model.*;
import com.dopingtech.testcenter.repository.QuestionChoiceRepository;
import com.dopingtech.testcenter.service.StudentService;
import com.dopingtech.testcenter.service.StudentTestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentTestService studentTestService;

    public StudentServiceImpl(StudentTestService studentTestService) {
        this.studentTestService = studentTestService;
    }

    @Override
    public Map<Long, List<StudentTest>> getMyTests(Long studentId) {
        return studentTestService.getStudentTests(studentId).stream().collect(Collectors.groupingBy(studentTest -> studentTest.getTest().getId()));
    }

    @Override
    public List<StudentTest> getMyTest(Long studentId, Long testId) {
        return studentTestService.getStudentTest(studentId, testId);
    }
}
