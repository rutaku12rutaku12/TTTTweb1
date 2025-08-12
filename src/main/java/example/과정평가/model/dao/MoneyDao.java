package example.과정평가.model.dao;

import example.과정평가.model.dto.MoneyDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MoneyDao extends Dao{

    // [1] 조회
    public List<MoneyDto> moneyPrint(){
        System.out.println("MoneyDao.moneyPrint");
        List<MoneyDto> list = new ArrayList<>();
        try{
            // 1. SQL 작성
            String sql = "select member.custno as 회원번호, member.custname as 회원성명 , \n" +
                    "case member.grade\n" +
                    "when 'A' then 'VIP'\n" +
                    "when 'B' then '일반'\n" +
                    "when 'C' then '직원'\n" +
                    "end as 고객등급 , sum((money.price-money.pcost)*(money.amount)) as 매출 \n" +
                    "from member join money on member.custno = money.custno \n" +
                    "where member.grade In ('A' , 'B', 'C')\n" +
                    "group by member.custno,member.custname,member.grade having sum((money.price-money.pcost)*(money.amount))>0 order by 매출 desc";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            while ( rs.next()){
                MoneyDto moneyDto = new MoneyDto();
                moneyDto.setCustno(rs.getInt("회원번호"));
                moneyDto.setCustname(rs.getString("회원성명"));
                moneyDto.setGrade(rs.getString("고객등급"));
                moneyDto.set매출(rs.getInt("매출"));
                // 6. 생성한 dto 를 리스트에 저장
                list.add( moneyDto );
            }
        }catch (Exception e){System.out.println(e);}
        return list;
    } // m end
} // class end























