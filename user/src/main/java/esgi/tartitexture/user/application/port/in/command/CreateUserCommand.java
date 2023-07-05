package esgi.tartitexture.user.application.port.in.command;

public class CreateUserCommand {

    private String password;

    private String email;

    private String name;

    private String lastname;

    public CreateUserCommand(String email, String password, String name, String lastname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
