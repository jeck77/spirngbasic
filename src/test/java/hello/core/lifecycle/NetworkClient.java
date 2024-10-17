package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

// implements InitializingBean, DisposableBean
// InitializingBean 초기화 빈(의존관계 끝나면 그 때 호출)
// DisposableBean 의존관계가 종료될 때 호출
// 단점 : 스프링 전용 인터페이스, 내가 코드를 고칠 수 없는 라이브러리에 적용할 수 없다.

// @Bean(initMethod = "init", destroyMethod = "close")
// 장점 : 메소드명을 자유롭게 가능, 스프링에 의존 되지 않음, 코드를 고칠 수 없는 외부 라이브러리에 적용 가능
// destroyMethod 특별한 기능 default 값은 (inferred)으로 등록 되어 있어서 메소드를 추론해서 종료 메서드를 호출 해준다.
// 추론 기능을 쓰기 싫으면 destroyMethod = "" 빈 값으로 설정한다.

// 애노테이션 @PostConstruct, @PreDestroy
// 스프링에 종속적인 기술이 아니라 자바 표준
// 컴포넌트 스캔과 어울린다.
// 단점 : 외부라이브러리에 적용 불가능
public class NetworkClient  {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect = " + url);
    }

    // 서비스 호출
    public void call(String message){
        System.out.println("call = " + url + " message = " + message);
    }

    // 사비스 종료시 호출
    public void disconnect(){
        System.out.println("close = " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }

    @PostConstruct
    public void init(){
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close(){
        disconnect();
    }

}
