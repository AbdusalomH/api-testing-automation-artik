package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class ResponseSpecs {

    private static ResponseSpecBuilder responseSpecBuilder() {
        return new ResponseSpecBuilder();
    }

    public static ResponseSpecification entityWasSuccess() {
        return responseSpecBuilder().expectStatusCode(HttpStatus.SC_OK).build();
    }

    public static ResponseSpecification entityWasCreated() {
        return responseSpecBuilder().expectStatusCode(HttpStatus.SC_CREATED).build();
    }

}
