package model.restpayloads;

import java.util.Date;

public class UpdateUser {

    private int id;
    private String email;

    private String phone;
    private Integer sex;
    private Date birthday;
    private String name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public UpdateUser(){ }

    public UpdateUser(int id, String email, String phone, Integer sex, Date birthday, String name) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.name = name;
    }

    public UpdateUser(int id, String email, String name) {
        this.id = id;
        this.email = email;

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
