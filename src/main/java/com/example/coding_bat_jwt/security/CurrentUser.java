package com.example.coding_bat_jwt.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.PARAMETER})
@AuthenticationPrincipal
public @interface CurrentUser {

}
