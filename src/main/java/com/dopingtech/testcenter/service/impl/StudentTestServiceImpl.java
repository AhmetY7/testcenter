package com.dopingtech.testcenter.service.impl;

import com.dopingtech.testcenter.domain.dto.request.StudentTestRequest;
import com.dopingtech.testcenter.domain.exception.ApiRequestException;
import com.dopingtech.testcenter.domain.mapper.ToStudentTest;
import com.dopingtech.testcenter.domain.model.StudentTest;
import com.dopingtech.testcenter.repository.StudentTestRepository;
import com.dopingtech.testcenter.service.StudentTestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentTestServiceImpl implements StudentTestService {

    private final StudentTestRepository studentTestRepository;

    public StudentTestServiceImpl(StudentTestRepository studentTestRepository) {
        this.studentTestRepository  = studentTestRepository;
    }

    @Override
    public void save(StudentTestRequest testAnswers) {
        validate(testAnswers);
        List<StudentTest> studentTests = ToStudentTest.convert(testAnswers);
        studentTestRepository.saveAll(studentTests);
    }

    @Cacheable(value = "studentTestsCache", key = "#studentId")
    @Override
    public List<StudentTest> getStudentTests(Long studentId) {
        return studentTestRepository.findAllByStudentId(studentId);
    }

    @Cacheable(value = "studentTestCache", key = "{#studentId, #testId}")
    @Override
    public List<StudentTest> getStudentTest(Long studentId, Long testId) {
        return studentTestRepository.findAllByStudentIdAndTestId(studentId, testId);
    }

    private void validate(StudentTestRequest testAnswers) {
        List<StudentTest> studentTests = getStudentTest(testAnswers.getStudentId(), testAnswers.getTestId());
        studentTests.forEach(studentTest -> {
            if (testAnswers.getQuestionAndAnswers().stream().anyMatch(questionAnswerRequest -> questionAnswerRequest.getQuestionId().equals(studentTest.getQuestion().getId()))) {
                throw new ApiRequestException("Bu soru daha önce cevaplanmış. Soru: " + studentTest.getQuestion().getQuestion());
            }
        });
    }
}
