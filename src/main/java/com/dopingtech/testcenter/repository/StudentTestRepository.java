package com.dopingtech.testcenter.repository;

import com.dopingtech.testcenter.domain.model.StudentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentTestRepository extends JpaRepository<StudentTest, Long> {

    List<StudentTest> findAllByStudentId(Long studentId);
    List<StudentTest> findAllByStudentIdAndTestId(Long studentId, Long testId);
}
