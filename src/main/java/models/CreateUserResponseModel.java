package models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)

public class CreateUserResponseModel extends BaseModel {
    private long id;
    private String username;
    private String password;
    private String name;
    private String role;
    private List<CreateAccountResponseModel> accounts;
}
