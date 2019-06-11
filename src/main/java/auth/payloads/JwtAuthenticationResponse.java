package auth.payloads;

import model.Role;

public class JwtAuthenticationResponse {
    private int userId;
    private Role role;
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(int userId, Role role,  String accessToken) {
        this.userId = userId;
        this.role = role;
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
