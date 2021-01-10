package pl.sda.java.project.finalproject.exceptions;

public class UserDoesntExistException extends RuntimeException {

    private String username;

    public UserDoesntExistException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return String.format("User identified by %s couldn't be found.", username);
    }

    public String getUsername() {
        return username;
    }

}
