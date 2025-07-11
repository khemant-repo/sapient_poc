package demo;

import java.util.Set;
import java.util.HashSet;

public class Test {

/*
    private FileShareService fileShareService; //
    // interface for SMBJFileShareService
    private boolean initiazeFileShareService(String remoteLocation){
        boolean isDirectory = false;
        NTLMPasswordAuthentication auth = getAuthentication();
        NTLMAuthDetails autDetails = new NTLMAuthDetails(auth.getDomain(),auth.getUsername(),auth.getpassword());
        fileShareService = new SMBJFileShareService(new SMBJConnectionResource());
        try {
            isDirectory =  fileShareService.connect(autDetails,hostName,remoteLocation);

        } catch(IOException ex){}
        return isDirectory;

    }
public void copyFileToRemoteLocation(String remoteLocation){

        if(initiazeFileShareService(remoteLocation)){
            // logic to upload file
        }else {
            log.info("remoteLocation is not a directory ");
        }
}*/

    public static void main(String[] args) {
        Set<MyClass> mySet = new HashSet<>();
        mySet.add(new MyClass(1));
        mySet.add(new MyClass(2));
        mySet.add(new MyClass(3));
        mySet.add(new MyClass(4));
        mySet.add(new MyClass(5));
        Set<MySecondClass> mySet1 = new HashSet<>();
        mySet1.add(new MySecondClass(1));
        mySet1.add(new MySecondClass(2));
        mySet1.add(new MySecondClass(3));
        mySet1.add(new MySecondClass(4));
        mySet1.add(new MySecondClass(5));
        // Pass the set to a generic method
        processSet(mySet,mySet1);
    }
    
    public static <T, U> void processSet(Set<T> set,Set<U> mySet1) {
        System.out.println("Set contains:");
        
        // Iterate and print all objects
        for (T obj : set) {
            System.out.println(obj);
        }
    }
}

class MyClass {
    int value;

    MyClass(int value) {
        this.value = value;
    }

   /* @Override
    public String toString() {
        return "MyClass{" + "value=" + value + '}';
    }*/
}

class MySecondClass {
    int value;

    MySecondClass(int value) {
        this.value = value;
    }

   /* @Override
    public String toString() {
        return "MySecondClass{" + "value=" + value + '}';
    }*/
}
