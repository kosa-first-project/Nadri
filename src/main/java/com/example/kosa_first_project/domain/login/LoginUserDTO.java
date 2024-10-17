package com.example.kosa_first_project.domain.login;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTO {

        private String id;

        private String password;

}
