package web.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
            ps.setString(2,memberDto.getMpwd());
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
    public MemberDto info( int mno ){
        System.out.println("MemberDao.info");
        try{
            // 1. SQL 작성
            String sql = "select * from member where mno=?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,mno);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                MemberDto memberDto = new MemberDto(); // 패스워드 제외한
                memberDto.setMno( rs.getInt("mno"));
                memberDto.setMid( rs.getString("mid"));
                memberDto.setMname( rs.getString("mname"));
                memberDto.setMphone( rs.getString("mphone"));
                memberDto.setMdate( rs.getString("mdate"));
                return memberDto;
            }
            // 5. SQL 결과에 따른 로직/리턴/확인
        }catch (Exception e){System.out.println(e);}
        return null;
    }

    // [5] 특정할 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check( String type , String data ){
        try{
            // 1. SQL 작성
            String sql = "select * from member where "+type+" = ? ";
            // String sql = "select * from member where mid = ? "; // where 뒤에 띄어쓰기 해야함!
            // String sql = "select * from member where mphone = ? ";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,data);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( rs.next() ){return true;} // 중복이면 true
        }catch (Exception e){System.out.println(e);}
        return false; // 중복이 아니면 false
    }

    // [6] 회원정보수정
    public boolean update( MemberDto memberDto ){
        try{
            // 1. SQL 작성
            String sql = "update member set mname = ? , mphone = ? where mno =? ";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,memberDto.getMname());
            ps.setString(2, memberDto.getMphone());
            ps.setInt(3,memberDto.getMno());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true; // 같은 식 = return count == 1;
        }catch (Exception e){System.out.println(e);}
        return false;
    }

    // [7] 회원비밀번호수정 : 현재 로그인된 회원의 패스워드와 일치하면 패스워드 수정
    public boolean updatePassword( int mno , Map<String, String> map ){
        try{
            // 1. SQL 작성
            String sql = "update member set mpwd = ? where mno = ? and mpwd = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,map.get("newpwd")); // 새로운 패스워드 (수정용)
            ps.setInt(2,mno);
            ps.setString(3,map.get("oldpwd")); // 기존 패스워드 (확인용)
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            return count == 1;
        }catch (Exception e){System.out.println(e);}
        return false;
    }

    // [8] 회원탈퇴
    public boolean delete( int mno , String oldpwd){ // oldpwd(삭제하기전확인용)
        try{
            // 1. SQL 작성
            String sql = "delete from member where mno = ? and mpwd = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,mno);
            ps.setString(2,oldpwd);
            // 4. SQL 실행
            return ps.executeUpdate() == 1;
            // 5. SQL 결과에 따른 로직/리턴/확인
        }catch (Exception e){System.out.println(e);}
        return false;
    } // m end

//    // [9] 아이디 찾기 : 입력 이름+연락처 , 일치 시 아이디 반환
//    public String findId( List<Map<String, String>> list){
//        try{
//            // 1. SQL 작성
//            String sql = "select mid from member where mname = ? and mphone = ?";
//            // 2. SQL 기재
//            PreparedStatement ps = conn.prepareStatement(sql);
//            // 3. SQL 매개변수 대입
//            ps.setString(1,list.get(0).get("mname"));
//            ps.setString(2,list.get(1).get("mphone"));
//            // 4. SQL 실행
//            ResultSet rs = ps.executeQuery();
//            // 5. SQL 결과에 따른 로직/리턴/확인
//            if( rs. next() ) return rs.getString("mid");
//        }catch (Exception e){System.out.println(e);}
//        return null; // 못찾으면 null
//    }
    // [9-1] 아이디 찾기 : 입력 이름+연락처 , 일치 시 아이디 반환
    public String findId( Map<String, String> map){
        try{
            // 1. SQL 작성
            String sql = "select mid from member where mname = ? and mphone = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,map.get("mname"));
            ps.setString(2,map.get("mphone"));
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( rs. next() ) return rs.getString("mid");
        }catch (Exception e){System.out.println(e);}
        return null; // 못찾으면 null
    }

//    // [10] 비밀번호 찾기
//    public String findPwd( Map < String , String > map ){
//        try{// 1. SQL 작성
//            String sql = "update member set mpwd = ? where mid = ? and mphone = ? ";
//            // 2. SQL 기재
//            PreparedStatement ps = conn.prepareStatement(sql);
//                // * 난수 생성
//                Random random = new Random();
//                int rand = random.nextInt(900000)+100000; // 100000~999999 숫자
//                String rand1 = String.valueOf(rand); // 숫자를 문자로 강제타입변환
//            // 3. SQL 매개변수 대입
//            ps.setString(1, rand1);
//            ps.setString(2,map.get("mid"));
//            ps.setString(3,map.get("mphone"));
//            // 4. SQL 실행
//            int count = ps.executeUpdate();
//            // 5. SQL 결과에 따른 로직/리턴/확인
//            if( count == 1 ) return rand1;
//        }catch (Exception e){System.out.println(e);}
//        return "0";
//    }

    // [10-1] 비밀번호 찾기
    public boolean findPwd( Map < String , String > map ){
        try{// 1. SQL 작성
            String sql = "update member set mpwd = ? where mid = ? and mphone = ? ";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,map.get("mpwd"));
            ps.setString(2,map.get("mid"));
            ps.setString(3,map.get("mphone"));
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            return count == 1;
        }catch (Exception e){System.out.println(e);}
        return false;
    }

} // class end




















