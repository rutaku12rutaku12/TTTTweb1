package example.day03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 기본 세팅 + 컴포넌트 스캔 + 내장 톰캣(서버) 실행
public class AppStart {
    public static void main(String[] args) {

        SpringApplication.run( AppStart.class ); // 여러개 콘솔창 실행 불가능!

    } // main end
} // class end

