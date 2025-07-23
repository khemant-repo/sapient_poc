package practice;

public class MainApp {

    public static void main(String[] args) {
        spin();
    }

    public int add(int i, int j){
        return i+j;
    }
    private static void spin() {
        int j = 1000000;
        for (int i=0; i< 100 ;i++){
            System.out.println(i);
        }
    }


}
