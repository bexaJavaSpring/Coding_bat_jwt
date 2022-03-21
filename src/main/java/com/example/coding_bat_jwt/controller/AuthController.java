package com.example.coding_bat_jwt.controller;

import com.example.coding_bat_jwt.dto.LoginDto;
import com.example.coding_bat_jwt.entity.User;
import com.example.coding_bat_jwt.security.CurrentUser;
import com.example.coding_bat_jwt.security.JWTProvider;
import com.example.coding_bat_jwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    final JWTProvider jwtProvider;
    final AuthenticationManager authenticationManager;
    final AuthService authService;

    @PostMapping("login")
    public HttpEntity<?> login(@RequestBody LoginDto dto) {
        String token = jwtProvider.generateToken(dto.getUserName());
        return ResponseEntity.ok().body(token);
    }

    @GetMapping("/me")
    public HttpEntity<?> getMe(@CurrentUser User user) { //Parametr
        return ResponseEntity.ok().body("Mana" + user);
    }
}
