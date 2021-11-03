import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@Data
public class UsersResponse {
    public int page;
    @JsonProperty("per_page")
    public int perPage;
    public int total;
    @JsonProperty("total_pages")
    public int totalPages;
    public ArrayList<UserData> data;
    public Object support;
}
