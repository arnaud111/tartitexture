package esgi.tartitexture.user.adapter.in.controller.response;

public class UserResponse {

    public final int id;
    public final String email;
    public final String name;
    public final String lastname;

    public UserResponse(int id, String email, String name, String lastname) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
    }
}
