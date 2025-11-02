package api;

import assertions.UserBalanceProvider;
import models.CreateAccountResponseModel;
import models.CreateUserRequestModel;
import org.junit.jupiter.api.Test;
import requests.Endpoint;
import requests.ValidatedCrudRequester;
import requests.steps.AdminSteps;
import specs.RequestSpecs;
import specs.ResponseSpecs;

public class CreateAccountTest extends BaseTest {

    @Test
    public void userCanCreateAccount() {
        CreateUserRequestModel createUserRequestModel = AdminSteps.createUser();

        CreateAccountResponseModel createAccount =  new ValidatedCrudRequester<CreateAccountResponseModel>
                (RequestSpecs.authUser(createUserRequestModel.getUsername(),
                        createUserRequestModel.getPassword()),
                        Endpoint.ACCOUNTS,
                        ResponseSpecs.entityWasCreated())
                .post(null);

        CreateAccountResponseModel createdAccount = UserBalanceProvider
                .getUserAccount(createUserRequestModel.getUsername());

        softly.assertThat(createAccount.getBalance()).isEqualTo(createdAccount.getBalance());
    }
}
