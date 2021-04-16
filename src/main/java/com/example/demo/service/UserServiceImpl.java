package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    final PasswordEncoder passwordEncoder;
    final UserRepository userRepository;

    @Override
    public void signup(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserEntity userEntity = dtoToEntity(userDTO);

        userEntity.addUserRole(UserRole.USER);
        userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername : " + username);

        Optional<UserEntity> result = userRepository.findByEmail(username);
        UserEntity userEntity = result.get();
        System.out.println(userEntity.toString());

        // Spring Security 와 jpa를 연결하여 -> jpa의 정보를 시큐리티가 인식할 수 있도록 인가정보를 생성해주는 코드
        UserDTO userDTO = new UserDTO(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRoleSet()
                .stream()
                .map(userRole -> new SimpleGrantedAuthority(
                        "ROLE_" + userRole.name()
                )).collect(Collectors.toSet())
        );

        userDTO.setName(userEntity.getName());
        userDTO.setPassword(userEntity.getPassword());

        System.out.println(userDTO.toString());

        return userDTO;
    }
}
