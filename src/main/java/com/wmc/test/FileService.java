package com.wmc.test;

public class FileService {



    // Simulates multithreaded race to create dir
    public void ensureDirExists(String dirPath) {
        FileShareService fileShareService = initiazeFileShareService(dirPath);
        fileShareService.createDirIfNotExist(dirPath);
    }

    // Simulate non-thread-safe existence check (always returns false)
    private boolean checkDirExists(String dirPath) {
        return false; // Assume dir never exists for demo
    }


    public FileShareService initiazeFileShareService(String remoteLocation) {
        NTLMPasswordAuthentication auth = getAuthentication();
        NTLMAuthDetails authDetails = new NTLMAuthDetails(auth.getDomain(), auth.getUsername(), auth.getPassword());

        try {
            FileShareService fileShareService = new SMBJFileShareService(new SMBJConnectionResource());
            if (fileShareService.connect(authDetails, "mockHost", remoteLocation)) {
                return fileShareService;  // ✅ Return the instance
            }
        } catch (Exception ex) {
            System.out.println("Exception in initiazeFileShareService: " + ex.getMessage());
        }
        return null; // Return null if connection fails
    }

    public void copyFileToRemoteLocation(String remoteLocation) {
        FileShareService fileShareService = null;
        fileShareService = initiazeFileShareService(remoteLocation); // ✅ Correctly assign

        try {
            if (fileShareService != null) {
                fileShareService.uploadFile("sample.txt");  // ✅ Now it's safe!
                System.out.println("File uploaded to: " + remoteLocation);
            } else {
                System.out.println("Remote location is not a directory");
            }
        }
       finally{
            fileShareService = null;
        }
    }

    private NTLMPasswordAuthentication getAuthentication() {
        return new NTLMPasswordAuthentication("mockDomain", "mockUser", "mockPassword");
    }
}
