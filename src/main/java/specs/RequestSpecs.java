package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.AdminUserModel;
import requests.UserLoginRequester;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RequestSpecs {

    private static RequestSpecBuilder defaultRequestBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .setBaseUri("http://localhost:4111");
    }

    public static RequestSpecification unauth() {
        return defaultRequestBuilder().build();
    }

    public static RequestSpecification adminSpecs() {
        AdminUserModel adminUserModel = AdminUserModel.builder().password("admin").username("admin").build();

        String token = new UserLoginRequester(RequestSpecs.unauth(), ResponseSpecs.entityWasSuccess())
                .requester(adminUserModel)
                .extract()
                .header("Authorization");
        System.out.println("token "+ token);
        return defaultRequestBuilder().addHeader("Authorization", token).build();
    }

}
