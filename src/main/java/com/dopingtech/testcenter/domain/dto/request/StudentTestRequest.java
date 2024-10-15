package com.dopingtech.testcenter.domain.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentTestRequest {

    private Long studentId;
    private Long testId;
    private List<QuestionAnswerRequest> questionAndAnswers;
}
