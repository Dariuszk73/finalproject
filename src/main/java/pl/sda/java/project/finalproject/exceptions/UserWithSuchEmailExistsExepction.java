package pl.sda.java.project.finalproject.exceptions;

import javax.validation.constraints.Email;

public class UserWithSuchEmailExistsExepction extends RuntimeException{
    public UserWithSuchEmailExistsExepction(@Email(message = "User already exists") String email) {
    }
}
