package example.실습.실습4.model.dto;

import lombok.*;
// 2. 생성자
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 풀생성자
// 3. getter and setter , toString
@Getter // getter
@Setter // setter
@ToString // toString
public class WaitingDto {
    // 1. 멤버변수
    private int wno; // 대기번호
    private String wphone; // 연락처
    private int wcount; // 인원수
    private String wdate; // 등록일자

}
