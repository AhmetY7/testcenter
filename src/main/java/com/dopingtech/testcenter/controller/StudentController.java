package com.dopingtech.testcenter.controller;

import com.dopingtech.testcenter.domain.dto.response.StudentTestResponse;
import com.dopingtech.testcenter.domain.mapper.ToStudentTestResponse;
import com.dopingtech.testcenter.domain.model.Question;
import com.dopingtech.testcenter.domain.model.QuestionChoice;
import com.dopingtech.testcenter.domain.model.Student;
import com.dopingtech.testcenter.domain.model.Test;
import com.dopingtech.testcenter.domain.response.DataResponse;
import com.dopingtech.testcenter.domain.response.SuccessDataResponse;
import com.dopingtech.testcenter.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}/tests")
    public DataResponse<List<StudentTestResponse>> getMyTests(@PathVariable Long id) {
        return new SuccessDataResponse<>(studentService.getMyTests(id).values().stream().map(ToStudentTestResponse::convert).toList());
    }

    @GetMapping("/{id}/tests/{testId}")
    public DataResponse<StudentTestResponse> getMyTest(@PathVariable Long id, @PathVariable Long testId) {
        return new SuccessDataResponse<>(ToStudentTestResponse.convert(studentService.getMyTest(id, testId)));
    }
}
