package com.dopingtech.testcenter.domain.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerRequest {

    private Long questionId;
    private Long answerId;
}
