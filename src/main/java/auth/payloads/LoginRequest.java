package auth.payloads;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public String getUsernameOrEmail() {
        return email;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.email = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
