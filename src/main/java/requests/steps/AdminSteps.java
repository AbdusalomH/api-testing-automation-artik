package requests.steps;

import models.CreateUserRequestModel;
import models.CreateUserResponseModel;
import requests.AllureSteps;
import requests.Endpoint;
import requests.ValidatedCrudRequester;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class AdminSteps {

    public static CreateUserRequestModel createUser() {

        CreateUserRequestModel createUserRequestModel = CreateUserRequestModel.getUser();

        new ValidatedCrudRequester<CreateUserResponseModel>
                (RequestSpecs.adminSpecs(), Endpoint.ADD_USER, ResponseSpecs.entityWasCreated()).
                post(createUserRequestModel);

        return createUserRequestModel;
    }
}
