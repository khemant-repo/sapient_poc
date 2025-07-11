package com.wmc.test;

public class NTLMAuthDetails {
    private String domain;
    private String username;
    private String password;

    public NTLMAuthDetails(String domain, String username, String password) {
        this.domain = domain;
        this.username = username;
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
