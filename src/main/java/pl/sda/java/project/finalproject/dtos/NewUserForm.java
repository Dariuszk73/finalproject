package pl.sda.java.project.finalproject.dtos;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class NewUserForm {

    @Email(message = "User already exists")
   private String email;

    @Size(min = 8, max = 30, message = "Password lehgth must be min 8 and max 30")
    private String password;

    @NotNull
    @Size(max = 50)
    @NotBlank(message = "Nickname cannot be blank")
private String nickname;

    @Override
    public String toString() {
        return "NewUserForm{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
