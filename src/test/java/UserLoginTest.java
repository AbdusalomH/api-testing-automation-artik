import models.UserLoginRequestModel;
import org.junit.jupiter.api.Test;
import requests.UserLoginRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class UserLoginTest {


    @Test
    void userAbleToLogin() {

        UserLoginRequestModel adminModel = UserLoginRequestModel.builder().username("admin").password("admin").build();

        new UserLoginRequester(RequestSpecs.unauth(), ResponseSpecs.entityWasSuccess()).requester(adminModel);
    }
}
