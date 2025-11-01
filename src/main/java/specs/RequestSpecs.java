package specs;

import config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.UserLoginRequestModel;
import requests.CrudRequester;
import requests.Endpoint;

import java.util.List;

public class RequestSpecs {

    private static RequestSpecBuilder defaultRequestBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilters(List.of(new AllureRestAssured(), new ResponseLoggingFilter()))
                .setBaseUri(Config.getProperty("baseApiUrl"));
    }

    public static RequestSpecification unauth() {
        return defaultRequestBuilder().build();
    }

    public static RequestSpecification adminSpecs() {
        UserLoginRequestModel adminUserModel = UserLoginRequestModel.builder().password("admin").username("admin").build();

        String token = new CrudRequester(RequestSpecs.unauth(), Endpoint.LOGIN, ResponseSpecs.entityWasSuccess())
                .post(adminUserModel)
                .extract()
                .header("Authorization");
        return defaultRequestBuilder().addHeader("Authorization", token).build();
    }

    public static RequestSpecification authUser(String username, String password) {
        UserLoginRequestModel userLoginRequestModel = UserLoginRequestModel.builder()
                .username(username)
                .password(password)
                .build();
        String token = new CrudRequester(RequestSpecs.unauth(),Endpoint.LOGIN, ResponseSpecs.entityWasSuccess())
                .post(userLoginRequestModel)
                .extract()
                .header("Authorization");
        return defaultRequestBuilder().addHeader("Authorization", token).build();
    }
}
