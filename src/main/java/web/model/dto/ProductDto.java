package web.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    // 멤버변수는 기본(관례)로 DB테이블과 비슷
    private  int pno;        // 제품 코드 (기본키)
    private String pname;    // 제품명
    private int pprice;      // 제품 가격
    private String pcomment; // 제품 설명
    private String pdate;    // 등록일/시간
    private double plat;   // 위도 (예: 37.1234567)
    private double plng;   // 경도 (예: 127.1234567)
    private int mno;       // 등록자 (회원 번호 - FK)

    // + 커스텀(부가적인) 정보 포함
    // 1) 업로드에 사용할 multipartFile 객체를 List 타입으로 여러개 첨부파일 받아오기
    private List<MultipartFile> uploads;
    // 2) 조회시 업로드된 파일명을 문자열로 조회하기
    private List<String> images;
    // 3) 판매자의 아이디
    private int mid;
}

