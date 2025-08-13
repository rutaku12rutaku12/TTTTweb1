package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
    // 멤버변수 : 기본적으로 데이터베이스 테이블과 일치하게 하되, 상황에 따라 커스텀 해야한다.
   private int mno;         // 회원 번호
   private String mid;      // 회원 아이디
   private String mpwd;     // 비밀번호
   private String mname;    // 회원 이름
   private String mphone;   // 회원 연락처
   private String mdate;    // 가입일 datetime 은 다양한 타입이 존재하지만 편하게 문자타입으로 사용.
}
