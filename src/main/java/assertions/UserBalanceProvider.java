package assertions;

import models.CreateAccountResponseModel;
import models.CreateUserResponseModel;
import requests.CrudRequester;
import requests.Endpoint;
import specs.RequestSpecs;
import specs.ResponseSpecs;

import java.util.Arrays;

public class UserBalanceProvider {

    public static double getUserBalance(String username) {

        CreateUserResponseModel[] users = new CrudRequester(RequestSpecs.adminSpecs(), Endpoint.ADD_USER, ResponseSpecs.entityWasSuccess()).get().extract().as(CreateUserResponseModel[].class);

        return  Arrays.stream(users)
                .filter(f -> f.getUsername().equals(username))
                .map(u -> u.getAccounts().getFirst().getBalance())
                .mapToDouble(o -> Double.parseDouble(o.toString()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Balance not found"));
    }

    public static CreateAccountResponseModel getUserAccount(String username) {

        CreateUserResponseModel[] users = new CrudRequester(RequestSpecs.adminSpecs(), Endpoint.ADD_USER, ResponseSpecs.entityWasSuccess()).get().extract().as(CreateUserResponseModel[].class);

        return Arrays.stream(users)
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .flatMap(user -> user.getAccounts().stream().findFirst()) // берём первый аккаунт
                .orElseThrow(() -> new RuntimeException("No account found for user: " + username));

    }
}
