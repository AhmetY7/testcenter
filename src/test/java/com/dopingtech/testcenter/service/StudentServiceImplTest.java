package com.dopingtech.testcenter.service;

import com.dopingtech.testcenter.domain.model.Question;
import com.dopingtech.testcenter.domain.model.StudentTest;
import com.dopingtech.testcenter.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dopingtech.testcenter.util.Model.createStudentTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentTestService studentTestService;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void givenStudentId_whenGetStudentTests_thenReturnStudentTests() {
        Long studentId = 1L;
        StudentTest test1 = createStudentTest(1L, 1L);
        StudentTest test2 = createStudentTest(1L, 2L);
        StudentTest test3 = createStudentTest(2L, 3L);
        List<StudentTest> studentTests = Arrays.asList(test1, test2, test3);

        when(studentTestService.getStudentTests(studentId)).thenReturn(studentTests);

        Map<Long, List<StudentTest>> result = studentService.getMyTests(studentId);

        assertEquals(2, result.size());
        assertTrue(result.containsKey(1L));
        assertTrue(result.containsKey(2L));
        assertEquals(2, result.get(1L).size());
        assertEquals(1, result.get(2L).size());
        verify(studentTestService, times(1)).getStudentTests(studentId);
    }

    @Test
    void givenStudentIdAndTestId_whenGetStudentTest_thenReturnStudentTest() {
        Long studentId = 1L;
        Long testId = 2L;
        List<StudentTest> expectedTests = Arrays.asList(createStudentTest(testId, 1L), createStudentTest(testId, 2L));

        when(studentTestService.getStudentTest(studentId, testId)).thenReturn(expectedTests);

        List<StudentTest> result = studentService.getMyTest(studentId, testId);

        assertEquals(expectedTests, result);
        verify(studentTestService, times(1)).getStudentTest(studentId, testId);
    }
}