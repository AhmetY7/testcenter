package com.dopingtech.testcenter.service;

import com.dopingtech.testcenter.domain.dto.request.QuestionAnswerRequest;
import com.dopingtech.testcenter.domain.dto.request.StudentTestRequest;
import com.dopingtech.testcenter.domain.exception.ApiRequestException;
import com.dopingtech.testcenter.domain.model.Question;
import com.dopingtech.testcenter.domain.model.StudentTest;
import com.dopingtech.testcenter.repository.StudentTestRepository;
import com.dopingtech.testcenter.service.impl.StudentTestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.dopingtech.testcenter.util.Model.createStudentTest;
import static com.dopingtech.testcenter.util.Request.createStudentTestRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentTestServiceImplTest {

    @Mock
    private StudentTestRepository studentTestRepository;

    @InjectMocks
    private StudentTestServiceImpl studentTestService;

    @Test
    void givenStudentTestRequest_whenSaveStudentTest_thenReturnTrue() {
        StudentTestRequest testRequest = createStudentTestRequest(1L, 1L, 1L);

        when(studentTestRepository.findAllByStudentIdAndTestId(1L, 1L)).thenReturn(Arrays.asList());

        studentTestService.save(testRequest);

        verify(studentTestRepository, times(1)).saveAll(anyList());
    }

    @Test
    void givenStudentTestRequest_WhenSaveWithExistingAnswer_thenThrowException() {
        StudentTestRequest testRequest = createStudentTestRequest(1L, 1L, 1L);

        StudentTest existingTest = createStudentTest(1L, 1L);

        when(studentTestRepository.findAllByStudentIdAndTestId(1L, 1L)).thenReturn(Arrays.asList(existingTest));

        assertThrows(ApiRequestException.class, () -> studentTestService.save(testRequest));
    }

    @Test
    void givenStudentId_whenGetStudentTests_returnGetAllStudentTestList() {
        Long studentId = 1L;
        List<StudentTest> expectedTests = Arrays.asList(createStudentTest(1L,1L),createStudentTest(1L,2L));

        when(studentTestRepository.findAllByStudentId(studentId)).thenReturn(expectedTests);

        List<StudentTest> actualTests = studentTestService.getStudentTests(studentId);

        assertEquals(expectedTests, actualTests);
        verify(studentTestRepository, times(1)).findAllByStudentId(studentId);
    }

    @Test
    void givenStudentId_whenGetStudentTests_returnGetStudentTestList() {
        Long studentId = 1L;
        Long testId = 1L;
        List<StudentTest> expectedTests = Arrays.asList(createStudentTest(1L,1L),createStudentTest(1L,2L));

        when(studentTestRepository.findAllByStudentIdAndTestId(studentId, testId)).thenReturn(expectedTests);

        List<StudentTest> actualTests = studentTestService.getStudentTest(studentId, testId);

        assertEquals(expectedTests, actualTests);
        verify(studentTestRepository, times(1)).findAllByStudentIdAndTestId(studentId, testId);
    }
}
