package web.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository // 스프링 컨테이너에 빈 등록
public class MemberDao extends Dao{ // JDBC 연동 상속받기

    // [1] 회원가입
    public int signUp( MemberDto memberDto ){
        System.out.println("MemberDao.signUp");
        System.out.println("memberDto = " + memberDto);
        try{
            // 1. SQL 작성
            String sql = "insert into member (mid, mpwd, mname, mphone) VALUES (?,?,?,?)";
            // 2. SQL 기재 + ***auto_increment(자동 PK)값 경과를 반환 설정***
            PreparedStatement ps = conn.prepareStatement( sql , PreparedStatement.RETURN_GENERATED_KEYS );
            // 3. SQL 매개변수 대입
            ps.setString(1,memberDto.getMid());
            ps.setString(2,memberDto.getMpwd());
            ps.setString(3,memberDto.getMname());
            ps.setString(4,memberDto.getMphone());
            // 4. SQL 실행 한 결과 레코드 저장 개수 반환
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1) {
                // 6. auto_increment 로 자동 할당된 pk값 반환하여 rs로 조작하기
                ResultSet rs = ps.getGeneratedKeys();
                if( rs.next() ){ // 자동 할당된 pk 값중에 첫번째 pk값 으로 이동
                    int mno = rs.getInt(1); // pk값 가져오기
                    return mno; // 회원가입 성공한 회원의 번호를 반환한다.
                }
            }
        }catch (Exception e){System.out.println(e);}
        return 0; // 회원가입 실패시 0 반환한다.
    } // m end

    // [2] 로그인
    public int login(MemberDto memberDto){
        System.out.println("MemberDao.login");
        System.out.println("memberDto = " + memberDto);
        try{
            // 1. SQL 작성
            String sql = "select * from member where mid = ? and mpwd = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( rs.next() ){
                int mno = rs.getInt("mno");
                return mno; // 로그인 성공시 조회한 회원번호 반환
            }
        }catch (Exception e){System.out.println(e);}
        return 0; // 로그인 실패시 0 반환
    } // func end

    // [4] 내정보조회
    public MemberDto info(){
        System.out.println("MemberDao.info");
        try{
            // 1. SQL 작성
            String sql = "select * from member where mno=?";
            // 2. SQL 기재

            // 3. SQL 매개변수 대입
            // 4. SQL 실행
            // 5. SQL 결과에 따른 로직/리턴/확인
        }catch (Exception e){System.out.println(e);}

    }
} // class end










