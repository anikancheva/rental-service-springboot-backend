package web.projects.wheeler.models;

public class UserRegisterModel {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNo;

    public String getUsername() {
        return username;
    }

    public UserRegisterModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public UserRegisterModel setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }
}
