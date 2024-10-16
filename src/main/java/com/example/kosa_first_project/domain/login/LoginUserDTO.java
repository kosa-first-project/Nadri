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

        private String username;

        private String phone;

        private String gender;

        private String nickname;

        private String email;

        private LocalDateTime create_date;

        private String guide_activate;
}
