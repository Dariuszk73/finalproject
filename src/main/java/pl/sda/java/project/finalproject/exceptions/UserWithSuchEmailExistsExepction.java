package pl.sda.java.project.finalproject.exceptions;

public class UserWithSuchEmailExistsExepction extends RuntimeException{

    private final String email;

    public UserWithSuchEmailExistsExepction(String email) {
        this.email = email;
    }

    @Override
    public String getMessage() {
        return String.format("User identified by %s exist.", email);
    }

    public String getUsername() {
        return email;
    }
}
