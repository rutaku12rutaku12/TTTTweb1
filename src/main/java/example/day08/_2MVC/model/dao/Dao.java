package example.day08._2MVC.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

// 여러개 DAO를 연동하는 중복 코드를 관리하는 슈퍼클래스
public class Dao {
    // [DB연동]
    private String db_url = "jdbc:mysql://localhost:3306/spring08";
    private String db_user = "root";
    private String db_password = "1234";
    // [DB연동 멤버변수] * 싱글톤이 아니다.
    public Connection conn;
    // [DB연동] 생성자 * 싱글톤이 아니다.
    public Dao(){connect();}
    // [DB연동 메소드]
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
            System.out.println("Dao.connect"); // soutm 확인차
        }catch (Exception e){System.out.println(e);}
    }
}
