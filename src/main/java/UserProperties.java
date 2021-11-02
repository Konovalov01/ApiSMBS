import java.io.FileInputStream;
import java.io.IOException;

public class UserProperties {

    public static final String pathToProperties = "src/main/resources/properties/userProperties.properties";
    private FileInputStream fileInputStream;

    private String firstNameFirstTest,
            lastNameFirstTest,
            eMailFirstTest,
            firstNameSecondTest,
            lastNameSecondTest,
            eMailSecondTest;

    public UserProperties() throws IOException {

        java.util.Properties authorizationProp = new java.util.Properties();
        fileInputStream = new FileInputStream(pathToProperties);
        authorizationProp.load(fileInputStream);

        firstNameFirstTest = authorizationProp.getProperty("firstNameFirstTest");
        lastNameFirstTest = authorizationProp.getProperty("lastNameFirstTest");
        eMailFirstTest = authorizationProp.getProperty("eMailFirstTest");
        firstNameSecondTest = authorizationProp.getProperty("firstNameSecondTest");
        lastNameSecondTest = authorizationProp.getProperty("lastNameSecondTest");
        eMailSecondTest = authorizationProp.getProperty("eMailSecondTest");
    }

    public String getFirstNameFirstTest() {
        return firstNameFirstTest;
    }

    public String getLastNameFirstTest() {
        return lastNameFirstTest;
    }

    public String getEMailFirstTest() {
        return eMailFirstTest;
    }

    public String getFirstNameSecondTest() {
        return firstNameSecondTest;
    }

    public String getLastNameSecondTest() {
        return lastNameSecondTest;
    }

    public String getEMailSecondTest() {
        return eMailSecondTest;
    }

}
