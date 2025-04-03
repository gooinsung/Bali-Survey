package bali.balisurvey.domain.model.surveyItemReponse;

import bali.balisurvey.domain.base.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SurveyItemResponse extends BaseDomain {

    private Long seq;
    private Long surveyItemSeq;
    private String response;
}
