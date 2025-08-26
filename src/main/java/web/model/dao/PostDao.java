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
            String sql = "select count(*) from post where cno = ? "; // count(*) : 레코드 전체수 sql 함수
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
    } // func end

    // [2-3] 카테고리별 *검색* 게시물 수
    public int getTotalCountSearch( int cno , String key , String keyword ){
        try{
            // 1. sql 작성
            String sql = "select count(*) from post where cno = ?";
            // 2. key(속성명) 에 따른 sql 추가
            if( key.equals("ptitle") ){
                sql += " and ptitle like ? "; // 앞뒤로 띄어쓰기 꼭 넣기
            }else if( key.equals("pcontent") ){
                sql += " and pcontent like ? ";
            } // 그외 검색 속성이 존재하면 추가한다.
            System.out.println("[확인] 동적sql : " + sql);
            // 3.
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ps.setString(2,"%"+keyword+"%"); // sql 에서 포함된 비교는 like %키워드% 사용된다.
            // 4.
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){ return rs.getInt(1);}
        }catch (Exception e){System.out.println(e);}
        return 0;
    }

    // [2-4] 카테고리별 *검색* 전체 게시물 정보 조회
    public List<PostDto> findAllSearch( int cno , int startRow , int count , String key , String keyword ){
        List<PostDto> list = new ArrayList<>();
        try{String sql = " select * from post p inner join member m on p.mno = m.mno where cno = ? ";
            // **** 검색 SQL ****
            if( key.equals("ptitle") ){
                sql +=" and ptitle like ? ";}
            else if( key.equals("pcontent") ){
                sql +=" and pcontent like ? ";}
            // 그외(정렬/페이징)
            sql += " order by pno desc limit ? , ?";
            System.out.println("[확인]동적 SQL : " + sql);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,cno);
            ps.setString(2,"%"+keyword+"%");
            ps.setInt(3,startRow); ps.setInt(4,count);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                PostDto postDto = new PostDto();
                postDto.setMno(rs.getInt("mno")); postDto.setCno(rs.getInt("cno"));
                postDto.setPcontent(rs.getString("pcontent")); postDto.setPdate(rs.getString("pdate"));
                postDto.setPview(rs.getInt("pview")); postDto.setPno(rs.getInt("pno"));
                postDto.setPtitle(rs.getString("ptitle")); postDto.setMid(rs.getString("mid"));
                list.add(postDto); }
        }catch (Exception e){System.out.println(e);}
        return list;
    }



} // class end














