import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FirstTest {
    public UserProperties properties = new UserProperties();
    public Steps steps = new Steps();
    public ArrayList<UserData> listUser;
    public UsersResponse response;
    public UserData user;
    private String firstName,lastName;

    public FirstTest() throws IOException {
    }

    @Test
    public void firstTest() {
        firstName = properties.getFirstNameFirstTest();
        lastName = properties.getLastNameFirstTest();

        response = steps.getUsers("1");

        listUser = response.data;

        for (int i = 0; i < response.perPage; i++) {
            if ((listUser.get(i).firstName.equals(firstName)) && (listUser.get(i).lastName.equals(lastName))) {
                user = listUser.get(i);
                break;
            }
        }

        assertEquals("Email does not match ", properties.getEMailFirstTest(), user.email);

    }

    @Test
    public void secondTest() {

        firstName = properties.getFirstNameSecondTest();
        lastName = properties.getLastNameSecondTest();

        for (int j = 1; j <= steps.getUsers().totalPages; j++) {

            response = steps.getUsers(Integer.toString(j));

            listUser = response.data;

            for (int i = 0; i < response.perPage; i++) {
                if ((listUser.get(i).firstName.equals(firstName)) && (listUser.get(i).lastName.equals(lastName))) {
                    user = listUser.get(i);
                    break;
                }
            }
        }
        assertEquals("Email does not match ", properties.getEMailSecondTest(), user.email);

    }
}