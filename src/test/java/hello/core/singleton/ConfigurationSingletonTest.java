package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext();

        MemberServiceImpl memberSerivce = ac.getBean("memberSerivce", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("OrderServiceImpl", OrderServiceImpl.class);

        MemberRepository memberRepository1 = orderService.getMemberRepository();
        MemberRepository memberRepository12= orderService.getMemberRepository();

    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
    
}


