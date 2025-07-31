package example.day02._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller // 해당 클래스에 @Controller 어노테이션 주입
// 1. @Component : Spring 컨테이너(메모리) 에 bean(객체)를 등록/생성 한다. < 싱글톤 대신에 사용 >
// 2. Spring Controller 는 기본적으로 HTTP(웹) 통신 지원한다.
public class RestController {
    // 싱글톤 생략 : @Controller -> @Component 포함되서 자동으로 싱글톤 처럼 하나의 객체를 만들어준다.

    // Spring REST 란? @PostMapping , @GetMapping , @PutMapping , @DeleteMapping 등등 제공하므로 웹기술 제공
    // REST 란 ? CRUD 기능을 HTTP 로 제공하는 아키텍쳐/기술/구조
    // REST 테스터 : Talend API Tester - Free Edition
        // 1. 크롬 실행
        // 2. 크롬에 추가
        // 3. 크롬 켜서 확장프로그램 Talend API Tester 클릭
    // 1) 등록 : CREATE -> @PostMapping
    @PostMapping
    public void 등록하기() { // Talend API : [METHOD] GET , [Scheme] : http://localhost:8080/ , 주의할점 https 가 아닌 http
        System.out.println("RestController.등록하기"); // soutm 자동완성
    } // m end
    @GetMapping
    // 2) 조회 : READ -> @GetMapping
    public void 조회하기(){
        System.out.println("RestController.조회하기");
    } // m end
    @PutMapping
    // 3) 수정 : UPDATE -> @PutMapping
    public void 수정하기(){
        System.out.println("RestController.수정하기");
    } // m end
    @DeleteMapping
    // 4) 삭제 : DELETE -> @DeleteMapping
    public void 삭제하기(){
        System.out.println("RestController.삭제하기");

    } // m end
} // Class end

















