package example.과정평가.model.dao;

import example.과정평가.model.dto.MemberDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDao extends Dao{

    // [1] 등록
    public boolean memberAdd(MemberDto memberDto ){
        System.out.println("MemberDao.memberAdd");
        System.out.println("memberDto = " + memberDto);
        try{
            // 1. SQL 작성
            String sql = "insert into member (custname,phone,address,joindate,grade,city) values (?,?,?,?,?,?)";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,memberDto.getCustname());
            ps.setString(2,memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getJoindate());
            ps.setString(5,memberDto.getGrade());
            ps.setInt(6,memberDto.getCity());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true;
        }catch (Exception e){System.out.println(e);}
        return false;
    } // m end

    // [2] 전체조회
    public List<MemberDto> memberPrint(){
        System.out.println("MemberDao.memberPrint");
        // 0. 여러개 레코드를 dto로 변환해서 dto 들을 저장할 리스트 선언
        List<MemberDto> list = new ArrayList<>();
        try{
            // 1. SQL 작성
            String sql = "select * from member";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            while ( rs.next()){
                // 6. rs.get타입 () 현재 조회중인 레코드에서 속성값 호출
                MemberDto memberDto = new MemberDto();
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setCustname(rs.getString("custname"));
                memberDto.setPhone(rs.getString("phone"));
                memberDto.setAddress(rs.getString("address"));
                memberDto.setJoindate(rs.getString("joindate"));
                memberDto.setGrade(rs.getString("grade"));
                memberDto.setCity(rs.getInt("city"));
                // 7. 생성한 dto를 리스트에 저장
                list.add( memberDto );
            }
        }catch (Exception e){System.out.println(e);}
        return list;
    } // m end

    // [3] 개별조회
    public MemberDto memberFind( int custno ){
        try{
            // 1. SQL 작성
            String sql = "select * from member where custno = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,custno);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( rs.next() ){
                MemberDto memberDto = new MemberDto();
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setCustname(rs.getString("custname"));
                memberDto.setPhone(rs.getString("phone"));
                memberDto.setAddress(rs.getString("address"));
                memberDto.setJoindate(rs.getString("joindate"));
                memberDto.setGrade(rs.getString("grade"));
                memberDto.setCity(rs.getInt("city"));
                return memberDto; // 성공시 1개 dto
            }
        }catch (Exception e){System.out.println(e);}
        return null; // 실패시 null
    } // m end

    // [4] 개별수정
    public boolean memberUpdate( MemberDto memberDto ){
        try{
            // 1. SQL 작성
            String sql = "update member set custno = ? , custname = ? , phone = ? , address = ? , joindate = ? , grade = ? , city = ? where custno = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,memberDto.getCustno());
            ps.setString(2,memberDto.getCustname());
            ps.setString(3,memberDto.getPhone());
            ps.setString(4,memberDto.getAddress());
            ps.setString(5,memberDto.getJoindate());
            ps.setString(6,memberDto.getGrade());
            ps.setInt(7,memberDto.getCity());
            ps.setInt(8,memberDto.getCustno());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true;
        }catch (Exception e){System.out.println(e);}
        return false;
    } // m end
} // class end


















