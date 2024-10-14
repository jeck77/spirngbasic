package hello.core.singleton;

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
}
