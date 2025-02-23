package bali.balisurvey.domain.model.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Survey {
    private Long seq;
    private String title;
    private String description;
}
