package bali.balisurvey.domain.model.surveyItem;

import bali.balisurvey.domain.base.BaseDomain;
import bali.balisurvey.domain.enums.surveyItem.SurveyItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SurveyItem extends BaseDomain {

    private Long seq;
    private Long surveySeq;
    private String title;
    private String description;
    private SurveyItemType itemType;
}
