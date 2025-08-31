import io.restassured.specification.RequestSpecification;
import models.AccountResponseModel;
import models.CreateUserRequestModel;
import models.UserRole;
import org.junit.jupiter.api.Test;
import requests.AdminCreatUserRequester;
import requests.UserCreatesAccount;
import specs.RequestSpecs;
import specs.ResponseSpecs;
import utils.RandomData;

public class UserAccountTest extends BaseTest {


    @Test
    void userCanCreatAccount() {

        CreateUserRequestModel createUserRequestModel = CreateUserRequestModel.builder()
                .username(RandomData.getRandomUsername())
                .password(RandomData.getRandomPassword())
                .role(UserRole.USER.toString())
                .build();

        new AdminCreatUserRequester(RequestSpecs.adminSpecs(), ResponseSpecs.entityWasCreated()).requester(createUserRequestModel);

        AccountResponseModel account = new UserCreatesAccount(RequestSpecs.authUser(createUserRequestModel.getUsername(), createUserRequestModel.getPassword()), ResponseSpecs.entityWasCreated()).requester(null).extract().as(AccountResponseModel.class);

        softly.assertThat(account.getAccountNumber()).isNotEmpty();
        softly.assertThat(account.getBalance()).isEqualTo(0.0);

    }
}
