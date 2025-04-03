package bali.balisurvey.domain.enums.surveyItem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SurveyItemType {
    SHORT_ANSWER(1, "단답형"),
    LONG_ANSWER(2, "장문형"),
    SINGLE_CHOICE(3, "단일 선택형"),
    MULTIPLE_CHOICE(4, "다중 선택형"),
    RANKING(5, "순위형"),
    ;
    private final Integer type;
    private final String description;
}
