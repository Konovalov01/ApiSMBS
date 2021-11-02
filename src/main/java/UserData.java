import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {
    public int id;
    public String email;
    @JsonProperty("first_name")
    public String firstName;
    @JsonProperty("last_name")
    public String lastName;
    public String avatar;
}
