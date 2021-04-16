package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class UserDTO extends User {
    private String email;
    private String password;
    private String name;

    // 내부 속성 값과 디비의 속성값을 이어주는 코드
    public UserDTO(String username, String password, Collection<? extends GrantedAuthority> authority){
        super(username, password, authority);

        this.email = username;
    }
}
