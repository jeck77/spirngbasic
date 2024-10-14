package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(
        // 컴포넌트 스캔 시작위치
        // 디폴트는 ComponentScan의 package 위치 부터 시작
        // * 권장하는 방법
        //개인적으로 즐겨 사용하는 방법은 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것
        //@Component 뿐만 아니라 다음과 내용도 추가로 대상에 포함한다. @Component : 컴포넌트 스캔에서 사용
        //@Controlller : 스프링 MVC 컨트롤러에서 사용
        //@Service: 스프링 비즈니스 로직에서 사용
        //@Repository: 스프링 데이터 접근 계층에서 사용 @Configuration : 스프링 설정 정보에서 사용
        basePackages = {"hello.core.member"},
        // 패키지 시작 위치
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Configuration.class})
)
public class AutoAppConfig {
}
