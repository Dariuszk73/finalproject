package pl.sda.java.project.finalproject.dtos;

public class UserSessionDto {
    private final String email;
    private final String nickname;

    public UserSessionDto(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
