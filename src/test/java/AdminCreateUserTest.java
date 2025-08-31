import models.CreatUserResponseModel;
import models.CreateUserRequestModel;
import models.UserRole;
import org.junit.jupiter.api.Test;
import requests.AdminCreatUserRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import utils.RandomData;

public class AdminCreateUserTest extends BaseTest {

    @Test
    public void adminCreatesNewUser() {

        CreateUserRequestModel createUserModel = CreateUserRequestModel.builder().username(RandomData.getRandomUsername()).password(RandomData.getRandomPassword()).role(UserRole.USER.toString()).build();
        CreatUserResponseModel creatUserResponseModel = new AdminCreatUserRequester(RequestSpecs.adminSpecs(), ResponseSpecs.entityWasCreated()).requester(createUserModel).extract().as(CreatUserResponseModel.class);


        softly.assertThat(createUserModel.getUsername()).isEqualTo(creatUserResponseModel.getUsername());
        softly.assertThat(createUserModel.getRole()).isEqualTo(creatUserResponseModel.getRole());
    }
}
