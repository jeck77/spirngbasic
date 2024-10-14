package hello.core.singleton;

import org.junit.jupiter.api.Test;

public class StatefulService {

   // private int price;


    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        //this.price = pirce; // 여기가 문제
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
