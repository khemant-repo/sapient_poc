package com.wmc.test;

public class NTLMPasswordAuthentication {
    private String domain;
    private String username;
    private String password;

    public NTLMPasswordAuthentication(String domain, String username, String password) {
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
