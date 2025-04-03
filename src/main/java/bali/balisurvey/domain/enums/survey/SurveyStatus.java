package bali.balisurvey.domain.enums.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SurveyStatus {
    CREATED(0, "설문조사 생성"),
    PUBLISHING(100, "설문조사 진행 중"),
    STOPPED(110, "임시 중단"),
    COMPLETED(200, "설문조사 완료");
    private final Integer status;
    private final String description;
}
