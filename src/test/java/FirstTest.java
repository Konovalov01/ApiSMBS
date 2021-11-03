import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {
    public UserProperties properties = new UserProperties();
    public Steps steps = new Steps();
    public ArrayList<UserData> listUser;
    public UsersResponse response;
    public UserData user;
    private List<UserData> listSearch;

    private String firstName,lastName;

    public FirstTest() throws IOException {
    }

    @Test
    public void firstTest() throws IOException {

        UserData dataSerch = new UserProperties().getDataFirstTest();

        response = steps.getUsers("1");

        listUser = response.data;

        listSearch =  listUser.stream().filter((p)-> p.firstName.equals(dataSerch.firstName) &&
                p.lastName.equals(dataSerch.lastName)).collect(Collectors.toList());

        assertTrue("user not found", listSearch.size() > 0);
        assertEquals("Email does not match ", dataSerch.email, listSearch.get(0).email);

    }

    @Test
    public void secondTest() throws IOException {

        UserData dataSerch = new UserProperties().getDataSecondTest();

        for (int j = 1; j <= steps.getUsers().totalPages; j++) {

            response = steps.getUsers(Integer.toString(j));

            listUser = response.data;

            listSearch =  listUser.stream().filter((p)-> p.firstName.equals(dataSerch.firstName) &&
                    p.lastName.equals(dataSerch.lastName)).collect(Collectors.toList());

            if(listSearch.size() > 0) {
                break;
            }
        }
        assertTrue("user not found", listSearch.size() > 0);
        assertEquals("Email does not match ", dataSerch.email, listSearch.get(0).email);

    }
}
