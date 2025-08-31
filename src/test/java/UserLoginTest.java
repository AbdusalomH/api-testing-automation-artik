import models.AdminUserModel;
import org.junit.jupiter.api.Test;
import requests.UserLoginRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class UserLoginTest {


    @Test
    void userAbleToLogin() {

        AdminUserModel adminModel = AdminUserModel.builder().username("admon").password("admin").build();

        new UserLoginRequester(RequestSpecs.unauth(), ResponseSpecs.entityWasSuccess()).requester(adminModel);



    }


}
