package com.dopingtech.testcenter.domain.dto.response;

import com.dopingtech.testcenter.domain.model.Student;
import com.dopingtech.testcenter.domain.model.Test;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentTestResponse {
    private Student student;
    private Test test;
    private List<QuestionChoiceResponse> answers;
    private int rightAnswers;
    private int wrongAnswers;
    private int totalNumberOfQuestions;
}
