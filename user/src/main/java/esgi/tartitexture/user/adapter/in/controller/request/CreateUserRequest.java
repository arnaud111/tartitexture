package esgi.tartitexture.user.adapter.in.controller.request;

public class CreateUserRequest {

    private String email;
    private String password;
    private String name;
    private String lastname;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
