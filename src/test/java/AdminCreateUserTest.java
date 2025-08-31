import models.CreatUserResponseModel;
import models.CreateUserModel;
import org.junit.jupiter.api.Test;
import requests.AdminCreatUserRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class AdminCreateUserTest extends BaseTest {

    @Test
    public void adminCreatesNewUser() {
        CreateUserModel createUserModel = CreateUserModel.builder().username("john_doe3").password("Tester09!").role("USER").build();
        CreatUserResponseModel creatUserResponseModel = new AdminCreatUserRequester(RequestSpecs.adminSpecs(), ResponseSpecs.entityWasCreated()).requester(createUserModel).extract().as(CreatUserResponseModel.class);
        System.out.println(creatUserResponseModel.getUsername()+" test here username");
    }
}
