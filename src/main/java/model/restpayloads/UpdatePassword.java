package model.restpayloads;

public class UpdatePassword {
    private int id;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

    public UpdatePassword() {
    }

    public UpdatePassword(int id, String oldPassword, String newPassword, String confirmNewPassword) {
        this.id = id;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }
}
