package com.creche.crecheapp.dto;

import java.util.Set;

public class UserDto {

    private static String username;

    private static String password;

    private static Set<String> roles;

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserDto.password = password;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        UserDto.roles = roles;
    }
}
