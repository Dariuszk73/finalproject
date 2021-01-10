package pl.sda.java.project.finalproject.exceptions;

import javax.validation.constraints.Email;

public class UserWithSuchEmailExistsExepction extends RuntimeException{
//    public UserWithSuchEmailExistsExepction(@Email(message = "User already exists") String email) {
//    }
    private String email;

    public UserWithSuchEmailExistsExepction(String email) {
        this.email = email;
    }

    @Override
    public String getMessage() {
        return String.format("User identified by %s couldn't be found.", email);
    }

    public String getUsername() {
        return email;
    }
}
