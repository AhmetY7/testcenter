package com.dopingtech.testcenter.domain.dto.response;

import com.dopingtech.testcenter.domain.model.Question;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionChoiceResponse {

    private Long id;
    private Question question;
    private char choiceSymbol;
    private String choice;
    private Boolean isRightAnswer;
}
