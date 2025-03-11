package bali.balisurvey.domain.model.user;

import lombok.Getter;

@Getter
public class User {

    private Long seq;
    private String userId;
    private String password;
    private String name;
    private String role;

    public User(Long seq, String userId, String password, String name, String role) {
        this.seq = seq;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
