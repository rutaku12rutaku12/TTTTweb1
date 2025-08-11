package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao{

    // [1] 등록
    public boolean boardWrite(BoardDto boardDto){
        System.out.println("BoardDao.boardWrite");
        System.out.println("boardDto = " + boardDto);
        try {
            String sql = "insert into board(bcontent,bwriter)values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardDto.getBcontent());
            ps.setString(2,boardDto.getBwriter());
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        }catch (Exception e){System.out.println(e);}
        return false;
    } // m end

    // [2] 전체조회
    public List<BoardDto> boardPrint() {
        List<BoardDto> list = new ArrayList<>(); // 1. 여러개 레코드를 dto로 반환해서 조회된 레코드 저장할 리스트 선언
        try {
            // 2. SQL 작성
            String sql = "select * from board";
            // 3. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 4. SQL 실행 후 결과 조작
            ResultSet rs = ps.executeQuery();
            // 5. rs.next() 조회된결과에서 다음 레코드 이동
            while( rs.next() ){
                BoardDto boardDto = new BoardDto();
                // 6. rs.getInt() 현재조회중인 레코드에서 bno속성값 호출
                boardDto.setBno( rs.getInt("bno"));
                boardDto.setBcontent( rs.getString("bcontent"));
                boardDto.setBwriter(rs.getString("bwriter"));
                // 7. 생성된 dto를 리스트에 저장
                list.add( boardDto );
            }
        } catch (Exception e) {System.out.println(e);}
        // 8. 리스트 반환
        return list;
    }

    // [3] 개별조회
    public BoardDto boardFind( int bno ) {
        try {
            String sql = "select * from board where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            // sql 문법내 첫번째 ? 에 int타입 bno 대입
            ps.setInt(1, bno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // while(rs.next()) : 여러개 조회
                // if( rs.next() ) : 한개 조회
                BoardDto boardDto = new BoardDto();
                boardDto.setBno(rs.getInt("bno"));
                boardDto.setBcontent(rs.getString(2));
                boardDto.setBwriter(rs.getString(3));
                return boardDto; // 성공시 1개 조회
            }
        } catch (Exception e) {System.out.println(e);}
         return null; // 실패시 null
    }

    // [4] 개별삭제
    public boolean boardDelete( int bno ) {
        try{
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if(count == 1){return true;}
        }catch (Exception e){System.out.println(e);}
        return false;
    }

    // [5] 개별수정
    public boolean boardUpdate( BoardDto boardDto ){
        try{
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardDto.getBcontent());
            ps.setInt(2,boardDto.getBno());
            int count = ps.executeUpdate();
            if(count == 1){return true;}
        }catch (Exception e){System.out.println(e);}
        return false;
    }
} // class end






























































