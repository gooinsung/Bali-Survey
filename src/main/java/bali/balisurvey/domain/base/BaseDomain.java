package bali.balisurvey.domain.base;

import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class BaseDomain {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean isDeleted;
}
