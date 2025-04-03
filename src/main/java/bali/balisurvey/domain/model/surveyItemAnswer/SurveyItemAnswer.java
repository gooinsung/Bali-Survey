package bali.balisurvey.domain.model.surveyItemAnswer;

import bali.balisurvey.domain.model.surveyItemAnswer.base.AnswerBaseDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SurveyItemAnswer extends AnswerBaseDomain {

    private Long seq;
    private Long surveyItemSeq;
}
