package bali.balisurvey.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.sql.Timestamp;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    protected Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    protected Timestamp updatedAt;

    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;
}
