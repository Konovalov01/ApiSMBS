import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {
    public UserProperties properties = new UserProperties();
    public Steps steps = new Steps();
    public ArrayList<UserData> listUser;
    public UsersResponse response;
    public Optional<UserData> userSearch;

    public FirstTest() throws IOException {
    }

    @Test
    public void firstTest() throws IOException {

        UserData dataSerch = new UserProperties().getDataFirstTest();

        response = steps.getUsers("1");

        listUser = response.data;

        userSearch =  listUser.stream().filter((p)-> p.firstName.equals(dataSerch.firstName) &&
                p.lastName.equals(dataSerch.lastName)).findFirst();

        assertTrue("User not found", userSearch.isPresent());
        assertEquals("Email does not match ", dataSerch.email, userSearch.get().email);
    }

    @Test
    public void secondTest() throws IOException {

        UserData dataSerch = new UserProperties().getDataSecondTest();

        for (int j = 1; j <= steps.getUsers().totalPages; j++) {

            response = steps.getUsers(Integer.toString(j));

            listUser = response.data;

            userSearch =  listUser.stream().filter((p)-> p.firstName.equals(dataSerch.firstName) &&
                    p.lastName.equals(dataSerch.lastName)).findFirst();

            if(userSearch.isPresent()) {
                break;
            }
        }
        assertTrue("User not found", userSearch.isPresent());
        assertEquals("Email does not match ", dataSerch.email, userSearch.get().email);
    }
}
