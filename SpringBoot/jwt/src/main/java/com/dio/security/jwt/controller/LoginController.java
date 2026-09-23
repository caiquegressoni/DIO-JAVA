package com.dio.security.jwt.controller;

import com.dio.security.jwt.dto.LoginDto;
import com.dio.security.jwt.dto.SessaoDto;
import com.dio.security.jwt.model.User;
import com.dio.security.jwt.repository.UserRepository;
import com.dio.security.jwt.security.JWTObject;
import com.dio.security.jwt.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<SessaoDto> logar(@RequestBody LoginDto login) {
        User user = userRepository.findByUsername(login.getUsername());
        if (user != null) {
            boolean passwordOk = passwordEncoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            SessaoDto sessao = new SessaoDto();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new java.util.Date(System.currentTimeMillis()));
            jwtObject.setExpiresAt(new java.util.Date(System.currentTimeMillis() + 3600000));
            jwtObject.setRoles(user.getRoles());
            jwtObject.setSubject(user.getUsername());

            sessao.setToken(jwtService.createToken(jwtObject));
            return ResponseEntity.ok(sessao);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
