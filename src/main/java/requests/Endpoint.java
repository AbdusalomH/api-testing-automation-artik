package requests;

import models.*;

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
    private final Class<? extends BaseModel> requestModel;
    private final Class<? extends BaseModel> responseModel;

    Endpoint(String url, Class<? extends BaseModel> requestModel, Class<? extends BaseModel> responseModel) {
        this.url = url;
        this.requestModel = requestModel;
        this.responseModel = responseModel;
    }

    public String getUrl() {
        return url;
    }

    public Class<?> getRequestClass() {
        return requestModel;
    }

    public Class<?> getResponseClass() {
        return responseModel;
    }
}
