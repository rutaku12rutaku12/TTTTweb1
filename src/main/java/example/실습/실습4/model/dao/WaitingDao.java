package example.실습.실습4.model.dao;

import example.실습.실습4.model.dto.WaitingDto;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {
    // 싱글톤
    @Getter // 롬복: 해당하는 멤버변수에만 getter 제공받을 수있다.
    private static final WaitingDao instance = new WaitingDao();
    private WaitingDao( ){ connect(); }
    // DB 정보
    private String db_url = "jdbc:mysql://localhost:3306/practice4";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    // 연동코드
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
        }catch (Exception e ){System.out.println(e);}
    } // 연동 end

    // 1. 등록
    public boolean save( WaitingDto waitingDto ){
        // controller 로부터 waitingDto를 매개변수로 받아서 처리후 boolean(true/false) 반환 메소드
         try{ // 예외처리
             // 1) SQL 작성한다
             String sql ="insert into waiting(wno,wphone,wcount) values(0,?,?)";
             // 2) 연동된 DB에 작성한 SQL 를 기재한다.
             PreparedStatement ps = conn.prepareStatement(sql);
             // 3) 기재된 SQL에 매개변수 대입
             ps.setString(1,waitingDto.getWphone());
             ps.setInt(2,waitingDto.getWcount());
             // 4) 기재된 SQL 실행한다.
             int count = ps.executeUpdate();
             // 5) 결과 , 1개 저장 했으면 성공
             if( count == 1 ) return true;
         }catch (Exception e){System.out.println(e);}
         return false; // 아니면 실패
    }

    // 2. 전체조회
    public List<WaitingDto> find(){
        List<WaitingDto> list = new ArrayList<>(); // 여러개 dto 담을 준비
        try{ // 예외처리
            // 1) SQl 작성한다
            String sql = "select * from waiting";
            // 2) SQL 를 기재한다.
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3) 기재된 SQL 실행
            ResultSet rs = ps.executeQuery();
            while( rs.next() ){ // 하나의 레코드를 DTO로 준비
                WaitingDto waitingDto = new WaitingDto(
                        rs.getInt(1),
                        rs.getString("wphone"),
                        rs.getInt("wcount"),
                        rs.getString("wdate")
                );
                list.add( waitingDto ); // 하나의 DTO를 리스트에 대입한다.
            }
        }catch (Exception e){System.out.println(e);}
        return list;
    } // class end
} // class end
























