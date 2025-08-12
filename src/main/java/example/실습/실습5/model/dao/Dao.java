package example.실습.실습5.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import static javax.management.remote.JMXConnectorFactory.connect;

public class Dao {
    // [DB 연동]
    private String db_url = "jdbc:mysql://localhost:3306/practice5";
    private String db_user = "root";
    private String db_password = "1234";
    // [DB 연동 멤버변수] 하위 클래스를 사용할 수 있게 public 으로 사용
    public Connection conn;
    // [DB 연동 생성자]
    public Dao(){connect();}
    // [DB 연동 메소드]
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
            System.out.println("Dao.connect"); // 확인용 soutm
        }catch (Exception e){System.out.println(e);}
    } // m end
} // class end
