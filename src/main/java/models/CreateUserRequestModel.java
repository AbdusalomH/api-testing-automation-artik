package models;


import groovyjarjarantlr4.v4.runtime.misc.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.RandomData;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateUserRequestModel extends BaseModel {

    private String username;
    private String password;
    private String role;

    public static CreateUserRequestModel getUser() {

        String userName = RandomData.getRandomUsername();
        String password = RandomData.getRandomPassword();
        String role = UserRole.USER.toString();
        return CreateUserRequestModel.builder().username(userName).password(password).role(role).build();
    }

}
