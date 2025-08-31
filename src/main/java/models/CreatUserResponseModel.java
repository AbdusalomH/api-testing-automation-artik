package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreatUserResponseModel {

    private long id;
    private String username;
    private String password;
    private String name;
    private String role;
    private List<String> accounts;
}

/*
{
    "id": 100,
    "username": "john_doe1",
    "password": "$2a$10$/MK9b6VwctPG7Wc5Y8xTg.cLNWWaqhpYtVRO1ZycfsVcJRG5x3bqC",
    "name": null,
    "role": "USER",
    "accounts": [

    ]
}
 */
