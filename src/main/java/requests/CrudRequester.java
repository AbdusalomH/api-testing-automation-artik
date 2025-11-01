package requests;

import config.Config;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CrudRequester extends HTTPRequest implements CrudInterfaces {

    String apiVersion = Config.getProperty("apiVersion");

    public CrudRequester(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
    }

    @Override
    public ValidatableResponse post(BaseModel baseModel) {

        var body = baseModel == null ? "" : baseModel;

        return AllureSteps.log("POST запрос к " + endpoint.getUrl(), () -> {

            // Логируем тело запроса
            AllureSteps.attachJson("REQUEST BODY", baseModel);

            ValidatableResponse response = given()
                    .spec(requestSpecification)
                    .body(body)
                    .when()
                    .post(apiVersion+endpoint.getUrl())
                    .then()
                    .spec(responseSpecification);

            // Логируем ответ
            AllureSteps.attachJson("RESPONSE BODY", response.extract().asString());

            return response;
        });
    }

    @Override
    public ValidatableResponse get() {


        return AllureSteps.log("GET запрос к " + endpoint.getUrl(), () -> {

            ValidatableResponse response = given()
                    .spec(requestSpecification)
                    .when()
                    .get(apiVersion+endpoint.getUrl())
                    .then()
                    .spec(responseSpecification);

            AllureSteps.attachJson("RESPONSE BODY", response.extract().asString());

            return response;
        });
    }

    @Override
    public ValidatableResponse put(BaseModel baseModel) {


        return AllureSteps.log("PUT запрос к " + endpoint.getUrl(), () -> {

            AllureSteps.attachJson("REQUEST BODY", baseModel);

            ValidatableResponse response = given()
                    .spec(requestSpecification)
                    .body(baseModel)
                    .when()
                    .put(apiVersion+endpoint.getUrl())
                    .then()
                    .spec(responseSpecification);

            AllureSteps.attachJson("RESPONSE BODY", response.extract().asString());

            return response;
        });
    }

    @Override
    public ValidatableResponse patch(BaseModel baseModel) {


        return AllureSteps.log("PATCH запрос к " + endpoint.getUrl(), () -> {

            AllureSteps.attachJson("REQUEST BODY", baseModel);

            ValidatableResponse response = given()
                    .spec(requestSpecification)
                    .body(baseModel)
                    .when()
                    .patch(apiVersion+endpoint.getUrl())
                    .then()
                    .spec(responseSpecification);

            AllureSteps.attachJson("RESPONSE BODY", response.extract().asString());

            return response;
        });
    }

    @Override
    public ValidatableResponse delete(int id) {
        return AllureSteps.log("DELETE запрос к " + endpoint.getUrl() + "/" + id, () -> {

            ValidatableResponse response = given()
                    .spec(requestSpecification)
                    .when()
                    .delete(apiVersion+endpoint.getUrl() + "/" + id)
                    .then()
                    .spec(responseSpecification);

            AllureSteps.attachJson("RESPONSE BODY", response.extract().asString());

            return response;
        });
    }
}
