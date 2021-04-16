package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    private String email;
    private String password;
    private String name;

    @ElementCollection(fetch= FetchType.LAZY)  // jpa 기능 / 1:多 관계 처리할 때 사용하는 어노테이션 / 테이블들끼리 관계를 맺어줄 때 사용
    @Builder.Default
    Set<UserRole> roleSet = new HashSet<>(); // Set은 리스트 같은거 (순서가 없음)

    public void addUserRole(UserRole userRole){
        roleSet.add(userRole);
    }
}
