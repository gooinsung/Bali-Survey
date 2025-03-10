package bali.balisurvey.common.auth.dto.command;

public record CreateJwtCommand(
    String userId,
    String name,
    String role,
    Long userSeq
) {

}
