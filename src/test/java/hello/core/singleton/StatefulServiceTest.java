package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService singletonService1 = ac.getBean(StatefulService.class);
        StatefulService singletonService2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자가 만원 주문
        int priceA = singletonService1.order("userA", 10000);
        // ThreadB : B 사용자가 만원 주문
        int priceB= singletonService2.order("userB", 20000);

        // ThreadA : 사용자A 주문 금액 조회
        //int price = singletonService1.getPrice();

        System.out.println("price = " + priceA);
        System.out.println("price = " + priceB);

        //Assertions.assertThat(price).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}