package com.wmc.test;

public interface FileShareService {
    boolean connect(NTLMAuthDetails authDetails, String hostName, String remoteLocation);
    void createDirIfNotExist(String path);
    void uploadFile(String remoteLocation);
}
