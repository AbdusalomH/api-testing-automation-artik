package requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.*;

@AllArgsConstructor
@Getter
public enum Endpoint {

    LOGIN(
          "/auth/login",
            UserLoginRequestModel.class,
            BaseModel.class
    ),

    ACCOUNTS(
            "/accounts",
            BaseModel.class,
            CreateAccountResponseModel.class
    ),

    DELETE_USER(
          "/admin/users/",
            BaseModel.class,
            BaseModel.class
    ),

    DEPOSIT(
            "/accounts/deposit",
            UserDepositRequestModel.class,
            CreateAccountResponseModel.class
    ),
    MODIFY (
            "/customer/profile",
            UsernameModifierRequestModel.class,
            UsernameModifiersResponseModel.class
    ),

    ADD_USER (
            "/admin/users",
            CreateUserRequestModel.class,
            CreatUserResponseModel.class
    );


    private final String url;
    private final Class<? extends BaseModel> RequestModel;
    private final Class<? extends BaseModel> ResponseModel;

}
