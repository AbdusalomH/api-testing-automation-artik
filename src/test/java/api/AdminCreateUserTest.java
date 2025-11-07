package api;

import models.CreatUserResponseModel;
import models.CreateUserRequestModel;
import models.UserRole;
import org.junit.jupiter.api.Test;
import requests.Endpoint;
import requests.ValidatedCrudRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import utils.RandomData;

public class AdminCreateUserTest extends BaseTest {

    @Test
    public void adminCreatesNewUser() {


        CreateUserRequestModel createUserModel = CreateUserRequestModel.builder().username(RandomData.getRandomUsername()).password(RandomData.getRandomPassword()).role(UserRole.USER.toString()).build();
        CreatUserResponseModel creatUserResponseModel = new ValidatedCrudRequester<CreatUserResponseModel>(RequestSpecs.adminSpecs(), Endpoint.ADD_USER, ResponseSpecs.entityWasCreated()).post(createUserModel);

        softly.assertThat(createUserModel.getUsername()).isEqualTo(creatUserResponseModel.getUsername());
        softly.assertThat(createUserModel.getRole()).isEqualTo(creatUserResponseModel.getRole());
    }
}
