package bali.balisurvey.domain.model.surveyItemAnswer.type;

import bali.balisurvey.domain.base.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class NormalAnswer extends BaseDomain {

    private Long seq;
    private Long surveyItemSeq;
    private String answer;
    private Long surveyItemAnswerSeq;
}
