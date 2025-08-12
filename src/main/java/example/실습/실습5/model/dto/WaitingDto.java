package example.실습.실습5.model.dto;

import lombok.*;

// 빈 생성자 , 풀 생성자 , getter and setter ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class WaitingDto {
    // 매개변수
    private int wno;
    private String phone;
    private int count;
    private String wdate;
}
