package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT DISTINCT u FROM User u WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.name, u.email"),
        @NamedQuery(name = User.BY_ID, query = "SELECT u FROM User u WHERE u.id=?1")
})

@Entity
@Table(name = "users")
@DynamicUpdate
public class User extends AbstractBaseEntity {

    public static final String DELETE = "User.delete";
    public static final String BY_EMAIL = "User.getByEmail";
    public static final String ALL_SORTED = "User.getAllSorted";
    public static final String BY_ID = "User.getById";

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "registered",
            columnDefinition = "timestamp default now()",
            updatable = false)

    private Date registered = new Date();


    @Column(name = "sex")
    private int sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    @JsonIgnore
    private boolean enabled = true;

    public User() {
    }

    public User(Integer id, String email, String password, String name, String phone, int sex, Date registred, boolean enabled, Date birthday) {
        super(id);
        this.enabled = enabled;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.registered = registred;
        this.birthday = birthday;
    }

    public User(Integer id, String email, String password, String name, String phone, int sex, Date registred, boolean enabled, Date birthday,  Role... roles){
        this(id,email,password,name,phone,sex,registred,enabled,birthday);
        setRoles(Arrays.asList(roles));
    }
    public User(Integer id, String email, String password, String name, String phone, int sex, Date registred, boolean enabled, Date birthday, Set<Role> roles) {
        this(id,email,password,name,phone,sex,registred,enabled,birthday);
        setRoles(roles);
    }
    public Set<Role>    getRoles() {
        return roles;
    }

    public Role getFirstRole() {return roles.stream().findFirst().get(); }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
