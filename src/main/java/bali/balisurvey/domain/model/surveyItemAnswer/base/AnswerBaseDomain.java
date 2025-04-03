package bali.balisurvey.domain.model.surveyItemAnswer.base;

import bali.balisurvey.domain.base.BaseDomain;
import lombok.Getter;

@Getter
public class AnswerBaseDomain extends BaseDomain {

    private String name;
    private String email;
    private String password;
}
