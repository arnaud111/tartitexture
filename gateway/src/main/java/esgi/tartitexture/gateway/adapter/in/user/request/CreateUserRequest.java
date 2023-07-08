package esgi.tartitexture.gateway.adapter.in.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;

@Builder
@JsonSerialize
public class CreateUserRequest {

    @JsonProperty(value = "email", required = true)
    private String email;
    @JsonProperty(value = "password", required = true)
    private String password;
    @JsonProperty(value = "name", required = true)
    private String name;
    @JsonProperty(value = "lastname", required = true)
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
