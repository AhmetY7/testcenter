package com.dopingtech.testcenter.service;

import com.dopingtech.testcenter.domain.model.*;

import java.util.List;
import java.util.Map;

public interface StudentService {

    Map<Long, List<StudentTest>> getMyTests(Long studentId);
    List<StudentTest> getMyTest(Long studentId, Long testId);
}
