package esgi.tartitexture.gateway.adapter.in.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

    @JsonProperty(value = "id", required = true)
    public int id;
    @JsonProperty(value = "email", required = true)
    public String email;
    @JsonProperty(value = "name", required = true)
    public String name;
    @JsonProperty(value = "lastname", required = true)
    public String lastname;

    public UserResponse() {

    }

    public UserResponse(int id, String email, String name, String lastname) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
    }
}
