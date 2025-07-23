package com.tuf.dsa;

import java.util.Arrays;
import java.util.List;

public class BuySellStocks {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(7,1,5,3,6,4);

        int mini = prices.get(0);
        int profit=0;

        for (int i=1;i<prices.size(); i++){
            int cost = prices.get(i) - mini ;
            System.out.println("Expected profit on buying at day: "+i
            +"for rupees "+prices.get(i) +" and selling on price:"+ mini +" is cost : "+cost);
            profit = Math.max(cost, profit);
            System.out.println("profit: "+profit);
            mini = Math.min(mini, prices.get(i));

        }
        System.out.println("profit is "+profit);
    }
}
