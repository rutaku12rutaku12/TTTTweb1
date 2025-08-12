package example.실습.실습5.model.dao;

import example.실습.실습5.model.dto.WaitingDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaitingDao extends Dao {

    // [1] 등록
    public boolean waitingAdd(WaitingDto waitingDto){
        System.out.println("WaitingDao.waitingAdd");
        System.out.println("waitingDto = " + waitingDto);
        try{
            // 1. SQL 작성
            String sql = "insert into waiting (phone,count) values ( ? , ? )";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,waitingDto.getPhone());
            ps.setInt(2,waitingDto.getCount());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true;
        }catch (Exception e){System.out.println(e);}
        return false;
    } // m end

    // [2] 전체조회
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingDao.waitingPrint");
        // 0. 여러개 레코드를 dto로 변환해서 dto 들을 저장할 리스트 선언
        List<WaitingDto> list = new ArrayList<>();
        try{
            // 1. SQL 작성
            String sql = "select * from waiting";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            // 6. 조회된 결과에서 다음 레코드 이동
            while ( rs.next()){
                // 7. rs.get타입 () 현재 조회중인 레코드에서 속성값 호출
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno( rs.getInt("wno"));
                waitingDto.setPhone(rs.getString("phone"));
                waitingDto.setCount(rs.getInt("count"));
                waitingDto.setWdate(rs.getString("wdate"));
                // 8. 생성한 dto 를 리스트에 저장
                list.add( waitingDto );
            }
        }catch (Exception e){System.out.println(e);}
        return list;
    } // m end

    // [3] 개별조회
    public WaitingDto waitingFind( int wno ){
        try{
            // 1. SQL 작성
            String sql = "select * from waiting where wno = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,wno);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( rs.next() ){
                // if( rs.next() ) 한개 조회
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno(rs.getInt(1));
                waitingDto.setPhone(rs.getString(2));
                waitingDto.setCount(rs.getInt(3));
                waitingDto.setWdate(rs.getString(4));
                return waitingDto; // 성공시 1개 dto
            }
        }catch (Exception e){System.out.println(e);}
        return null; // 실패시 null
    } // m end

    // [4] 개별삭제
    public boolean waitingDelete( int wno ){
        try{
            // 1. SQL 작성
            String sql = "delete from waiting where wno = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,wno);
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true;
        }catch (Exception e){System.out.println(e);}
        return false;
    } // m end

    // [5] 개별수정
    public boolean waitingUpdate( WaitingDto waitingDto ){
        try{
            // 1. SQL 작성
            String sql = "update waiting set phone = ? , count = ? where wno = ?"; // update set , , (and 아님!!)
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,waitingDto.getPhone());
            ps.setInt(2,waitingDto.getCount());
            ps.setInt(3,waitingDto.getWno());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true;
        }catch (Exception e){System.out.println(e);}
        return false;
    } // m end

} // class end















