package bali.balisurvey.adapter.out.persistence.user.entity;

import bali.balisurvey.adapter.out.persistence.entity.BaseEntity;
import bali.balisurvey.domain.enums.user.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "USER")
public class UserEntity extends BaseEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "USER_ID", nullable = false, length = 255, columnDefinition = "VARCHAR(255)")
    private String userId;

    @Column(name = "PASSWORD", nullable = true, length = 255, columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "NAME", nullable = false, length = 255, columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "ROLE", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String role;

    public UserEntity(String userId, String password, String name, String role) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.role = role == null ? UserRole.NORMAL_USER.getRole() : role;
    }

}
