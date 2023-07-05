package esgi.tartitexture.user.application.port.in.command;

public class UpdateUserCommand {

    private int id;

    private String password;

    private String email;

    private String name;

    private String lastname;

    public UpdateUserCommand(int id, String email, String password, String name, String lastname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
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
