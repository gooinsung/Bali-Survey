package bali.balisurvey.adapter.out.persistence.survey.entity;

import bali.balisurvey.adapter.out.persistence.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "SURVEY")
public class SurveyEntity extends BaseEntity {
    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "TITLE", nullable = false, columnDefinition = "VARCHAR(255)")
    private String title;

    @Column(name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
    private String description;

    public SurveyEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
