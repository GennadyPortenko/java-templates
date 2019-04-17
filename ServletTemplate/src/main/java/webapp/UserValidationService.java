package webapp;

public class UserValidationService {
    public boolean validate(String login, String password) {
        return login.equals("Gena") && password.equals("password");
    }
}
