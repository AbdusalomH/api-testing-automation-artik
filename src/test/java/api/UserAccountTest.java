package api;

import models.CreateUserRequestModel;
import models.UserRole;
import org.junit.jupiter.api.Test;
import requests.CrudRequester;
import requests.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import utils.RandomData;

public class UserAccountTest extends BaseTest {


    @Test
    void userCanCreateAccount() {

        CreateUserRequestModel createUserRequestModel = CreateUserRequestModel.builder()
                .username(RandomData.getRandomUsername())
                .password(RandomData.getRandomPassword())
                .role(UserRole.USER.toString())
                .build();

        new CrudRequester(RequestSpecs.adminSpecs(), Endpoint.ADD_USER, ResponseSpecs.entityWasCreated()).post(createUserRequestModel);
    }
}
