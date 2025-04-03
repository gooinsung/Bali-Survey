package bali.balisurvey.domain.model.surveyItemAnswer.type;

import bali.balisurvey.domain.base.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ChoiceAnswer extends BaseDomain {

    private Long seq;
    private Long surveyItemSeq;
    private Long surveyItemResponseSeq;
    private Long surveyItemAnswerSeq;
}
