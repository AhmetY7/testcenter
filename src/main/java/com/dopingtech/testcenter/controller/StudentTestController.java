package com.dopingtech.testcenter.controller;

import com.dopingtech.testcenter.domain.dto.request.StudentTestRequest;
import com.dopingtech.testcenter.domain.response.DataResponse;
import com.dopingtech.testcenter.domain.response.Response;
import com.dopingtech.testcenter.domain.response.SuccessResponse;
import com.dopingtech.testcenter.service.StudentService;
import com.dopingtech.testcenter.service.StudentTestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-tests")
public class StudentTestController {

    private final StudentTestService studentTestService;

    public StudentTestController(StudentTestService studentTestService) {
        this.studentTestService = studentTestService;
    }

    @PostMapping("")
    public Response save(@RequestBody StudentTestRequest studentTestRequest) {
        studentTestService.save(studentTestRequest);
        return new SuccessResponse("Test cevapları eklendi.");
    }
}
