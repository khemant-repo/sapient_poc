package com.wmc.test;

public class MainApplication {
    public static void main(String[] args) {

        FileService fileService = new FileService();
        String remoteLocation = "smb://mockserver/sharedfolder";

        // This will cause a NullPointerException
        fileService.ensureDirExists(remoteLocation);
    }
}
