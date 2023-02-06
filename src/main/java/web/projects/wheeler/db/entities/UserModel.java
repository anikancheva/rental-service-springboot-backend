package web.projects.wheeler.db.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import web.projects.wheeler.db.Role;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    @Length(max = 15)
    private String username;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotNull
    private String password;

    @NotNull
    @Pattern(regexp = "^\\([0-9]{3}\\)[0-9]{3}\\-[0-9]{4}$")
    private String phoneNo;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> authorities;
    public UserModel() {
    }


    public UserModel(String username, String firstName, String lastName, String email, String password, String phoneNo) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.authorities=new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public UserModel setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public UserModel setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
        return this;
    }
}
