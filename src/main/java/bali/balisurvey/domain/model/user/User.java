package bali.balisurvey.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private Long seq;
    private String userId;
    private String password;
    private String name;

    public User(Long seq, String userId, String name) {
        this.seq = seq;
        this.userId = userId;
        this.name = name;
    }
}
