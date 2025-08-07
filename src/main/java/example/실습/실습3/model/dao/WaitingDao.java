package example.실습.실습3.model.dao;

import example.실습.실습3.model.dto.WaitingDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WaitingDao {
        // *) 싱글톤
        private WaitingDao(){connect();}
        private static final WaitingDao instance = new WaitingDao();
        public static WaitingDao getInstance(){
            return instance;
        }
        // (*) DB 연동
        private String db_url = "jdbc:mysql://localhost:3306/practice3";
        private String db_user = "root";
        private String db_password = "1234";
        private Connection conn;
        private void connect(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(db_url,db_user,db_password);
            }catch (Exception e){System.out.println(e);}
        }

        // (1) 등록 기능 구현
        public boolean waitingAdd(WaitingDto waitingDto){
            try { // 1. SQL 작성
                String sql = "insert into waiting( wphone , wcount ) values (? , ?) ; ";
                // 2. SQL 기재
                PreparedStatement ps = conn.prepareStatement(sql);
                // 3. SQL 매개변수 대입  , ? 2개
                // SQL 내 1번째 ? 에 waitingDto의 wphone 값 대입
                ps.setString(1,waitingDto.getWphone());
                // SQL 내 2번째 ? 에 waitingDto의 wcount 값 대입
                ps.setInt(2,waitingDto.getWcount());
                // 4. SQL 실행
                int count = ps.executeUpdate();
                // 5. SQL 결과에 따른 로직/리턴/확인
                if( count >= 1 )return true; // 1개 이상 insert 했으면 성공
                return false; // 1개 이상 insert 못했으면 저장 실패
            }catch (Exception e){System.out.println(e);}
            return false; // catch 시 저장 실패
        } // func end

        // (2) 전체 조회 기능 구현
        public ArrayList<WaitingDto> waitingPrint(){
            ArrayList<WaitingDto> list = new ArrayList<>(); // 조회된 레코드(DTO) 저장할 리스트 선언
            try{
                // 1. SQL 작성
                String sql = "select * from waiting";
                // 2. SQL 기재
                PreparedStatement ps = conn.prepareStatement(sql);
                // 3. SQL 매개변수 대입 // 없음 생략
                // 4. SQL 실행
                ResultSet rs = ps.executeQuery();
                // 5. SQL 결과에 따른 로직/리턴/확인
                // 1) select 조회 결과를 레코드 하나씩 조회
                while( rs.next() ){ // rs.next() : ResultSet 인터페이스가 갖는 결과테이블에서 다음 레코드 이동 뜻
                    // 2) 조회중인 레코드를 속성값 호출해서 dto 만들기
                    int wno = rs.getInt("wno"); // rs.get타입("가져올속성명or번호")
                    String wphone = rs.getString("wphone");
                    int wcount = rs.getInt("wcount");
                    WaitingDto waitingDto = new WaitingDto( wno , wphone ,wcount ); // 레코드1개(열3개) => DTO 1개 (멤버변수3개)
                    // 3) 생성된 dto를 리스트에 담아주기
                    list.add( waitingDto);
                } // while end

            }catch (Exception e) {System.out.println(e);}
            return list;
        } // func end

        // (3) 삭제 기능 구현
        public boolean waitingDelete( int wno){
            try {
                // 1. SQL 작성
                String sql = "delete from waiting where wno=?";
                // 2. SQL 기재
                PreparedStatement ps = conn.prepareStatement(sql);
                // 3. SQL 매개변수 대입
                ps.setInt(1,wno); // SQL 문법내 첫번째 ? 의 int타입으로 wno 값 대임
                // 4. SQL 실행
                int count = ps.executeUpdate();
                // 5. SQL 결과에 따른 로직/리턴/확인
                if( count ==1)return true; // sql 결과 1이면 성공 , 1개만 삭제하기 때문에 (count==1)
                return false; // sql 결과 1아니면 실패
            }catch (Exception e){System.out.println(e);}
            return false; // 예외 발생시 실패
        } // func end

        // (4) 수정 기능 구현
        public boolean waitingUpdate( WaitingDto waitingDto ){
            try{
                // 1. SQL 작성
                String sql = "update waiting set wcount = ? where wno = ?";
                // 2. SQL 기재
                PreparedStatement ps = conn.prepareStatement(sql);
                // 3. SQL 매개변수 대입 , ? 2개
                ps.setInt(1,waitingDto.getWcount());   // sql내 1번째 ? 에 대입
                ps.setInt(2,waitingDto.getWno());     // sql내 2번째 ? 에 대입
                // 4. SQL 실행
                int count = ps.executeUpdate();
                // 5. SQL 결과에 따른 로직/리턴/확인
                if( count ==1 )return true; // sql 결과가 1개 이면 성공
                return false; // sql 결과가 1이 아니면 실패
            }catch (Exception e){System.out.println(e);}
            return false; // 예외발생시 실패
        } // func end
}
