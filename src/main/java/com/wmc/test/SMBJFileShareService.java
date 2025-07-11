package com.wmc.test;

import com.hierynomus.smbj.share.DiskShare;

public class SMBJFileShareService implements FileShareService{

    private SMBJConnectionResource connectionResource;
    private DiskShare share;
    public SMBJFileShareService(){

    }

    public SMBJFileShareService(SMBJConnectionResource connectionResource) {
        this.connectionResource = connectionResource;
    }


    @Override
    public boolean connect(NTLMAuthDetails authDetails, String hostName, String remoteLocation) {
        System.out.println("Connecting to " + remoteLocation);
        return true; // Simulating a successful connection
    }

    @Override
    public void createDirIfNotExist(String path) {

        synchronized (this){
            if(share.folderExists(path)){
                share.mkdir(path);
            }
        }

    }

    @Override
    public void uploadFile(String filePath) {
        System.out.println("Uploading file: " + filePath);
        // Simulated file upload logic
    }

}
