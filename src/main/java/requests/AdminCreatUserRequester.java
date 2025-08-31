package requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;

import static io.restassured.RestAssured.given;

public class AdminCreatUserRequester extends Request {

    public AdminCreatUserRequester(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        super(requestSpecification, responseSpecification);
    }

    @Override
    public ValidatableResponse requester(BaseModel model) {
        return given()
                .spec(requestSpecification)
                .body(model)
                .when()
                .post("/api/v1/admin/users").then().spec(responseSpecification);
    }
}
