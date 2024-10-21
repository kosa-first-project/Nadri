package com.example.kosa_first_project.domain.login;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    //회원ID
    private String id;

    //회원 비밀번호
    private String password;

    //회원 비밀번호 중복확인
    private String passwordCheck;

    //회원 이름
    private String username;

    //회원 전화번호
    private String phone;

    //회원 성별
    private String gender;

    //회원 닉네임
    private String nickname;

    //회원 이메일
    private String email;

    //회원가입 일 및 시간
    private LocalDateTime create_date;

    //일반 회원, 가이드 회원 여부
    private String guide_activate;
}
