package com.example.kosa_first_project.domain.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoinUserDTO {

    public String id;
    public String password;
    public String username;
    public String phone;
    public String gender;
    public String nickname;
    public String email;
    public String create_date;
    public String update_date;
}
