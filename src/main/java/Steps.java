import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Steps {
    public UsersResponse getUsers(String numberPage){
        return RestAssured
                .given()
                .header("Content-type", "application/json")
                .when()
                .get("https://reqres.in/api/users?page=" + numberPage)
                .getBody().as(UsersResponse.class);

    }

    public UsersResponse getUsers(){
        return RestAssured
                .given()
                .header("Content-type", "application/json")
                .when()
                .get("https://reqres.in/api/users")
                .getBody().as(UsersResponse.class);

    }
}
