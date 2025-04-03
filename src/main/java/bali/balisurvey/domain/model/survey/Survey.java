package bali.balisurvey.domain.model.survey;

import bali.balisurvey.domain.base.BaseDomain;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Survey extends BaseDomain {

    private Long seq;
    private Long userSeq;
    private String title;
    private String description;
    private Timestamp expiryDate;
}
