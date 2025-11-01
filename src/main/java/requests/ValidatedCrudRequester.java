package requests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BaseModel;

import java.util.Map;

public class ValidatedCrudRequester <T extends BaseModel> extends HTTPRequest implements CrudInterfaces {

    CrudRequester crudRequester;

    public ValidatedCrudRequester(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
        crudRequester = new CrudRequester(requestSpecification, endpoint, responseSpecification);
    }

    @Override
    public T post(BaseModel baseModel) {
        return (T) crudRequester.post(baseModel).extract().as(endpoint.getResponseModel());
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public T put(BaseModel baseModel) {
        return null;
    }

    @Override
    public T patch(BaseModel baseModel) {
        return null;
    }

    @Override
    public T delete(int id) {
        return null;
    }
}
