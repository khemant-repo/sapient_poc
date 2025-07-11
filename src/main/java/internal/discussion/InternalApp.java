package internal.discussion;

import com.java8.lambda.StreamUtil;

public class InternalApp {
    public static void main(String[] args) {

       // System.out.println("filter result :"+StreamUtil.filterItems());
        //System.out.println("map result: "+ StreamUtil.mapExample());
        System.out.println("for example...");
        StreamUtil.forExample();

        System.out.println("Reduce example: "+StreamUtil.reduceExample().getAsInt());

        System.out.println("max item: ");
        StreamUtil.maxExample();

        StreamUtil.groupbyExmaple();
    }
}
