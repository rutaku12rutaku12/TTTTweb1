package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.PostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDao extends Dao{

    // [1] 게시물 등록
    public int writePost(PostDto postDto){
        try{// 1. SQL 작성
            String sql = "insert into post( ptitle, pcontent, cno, mno ) values (?,?,?,?)";
            // 2. SQL 기재 , PreparedStatement.RETURN_GENERATED_KEYS : SQL 실행시 자동 생성된 PK 반환
            PreparedStatement ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
            // 3. SQL 매개변수 대입
            ps.setString(1,postDto.getPtitle());
            ps.setString(2,postDto.getPcontent());
            ps.setInt(3,postDto.getCno());
            ps.setInt(4,postDto.getMno());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1){
                ResultSet rs = ps.getGeneratedKeys(); // SQL 실행후 자동 생성된 PK 반환
                if( rs.next()) return rs.getInt(1); // 등록 성공시 첫번째 pk 속성 값 반환
            }
        }catch (Exception e){System.out.println(e);}
        return 0; // 등록 실패시
    } // func end

    // [2-1] 조회할 정보의 개수 ,
    public int getTotalCount( int cno ){
        try{// 1. SQL 작성
            String sql = "select count(*) from post where con = ? "; // count(*) : 레코드 전체수 sql 함수
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,cno);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( rs.next() ){
                return rs.getInt(1); // 첫번째 레코드의 속성값 1개 반환
            }
        }catch (Exception e){System.out.println(e);}
            return 0; // 조회 결과 없으면 0 반환
    } // func end

    // [2-2] 게시물 전체 조회
    public List<PostDto> findAll( int cno , int startRow , int count ) {
        List<PostDto> list = new ArrayList<>();
        try{// 1. SQL 작성
            String sql = "select * from post p inner join member m on p.mno= m.mno where p.cno = ? order by p.pno desc limit ?, ?;";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,cno);
            ps.setInt(2,startRow);
            ps.setInt(3,count);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            while ( rs.next() ){
                PostDto postDto = new PostDto();
                postDto.setMno(rs.getInt("mno"));
                postDto.setCno(rs.getInt("cno"));
                postDto.setPcontent(rs.getString("pcontent"));
                postDto.setPdate(rs.getString("pdate"));
                postDto.setPview(rs.getInt("pview"));
                postDto.setPno(rs.getInt("pno"));
                postDto.setPtitle(rs.getString("ptitle"));
                postDto.setMid(rs.getString("mid")); // member 테이블과 join한 결과 mid 호출 가능하다.
                list.add( postDto );
            }
        }catch (Exception e){System.out.println(e);}
        return list;
    }



} // class end














