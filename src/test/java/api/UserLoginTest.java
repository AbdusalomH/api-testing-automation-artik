package api;

import models.UserLoginRequestModel;
import org.junit.jupiter.api.Test;
import requests.CrudRequester;
import requests.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLoginTest {


    @Test
    void userAbleToLogin() {

        UserLoginRequestModel user = UserLoginRequestModel.builder().username("admin").password("admin").build();

        String token = new CrudRequester(RequestSpecs.unauth(), Endpoint.LOGIN, ResponseSpecs.entityWasSuccess()).post(user).extract().header("authorization");

        assertThat(token).isNotBlank();
    }
}
