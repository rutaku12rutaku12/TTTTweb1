package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.PointDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class PointDao extends Dao{
    // [1] 포인트 지급
    public int signPoint( PointDto pointDto ){
        try{ String sql = "INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pointDto.getMno());
            ps.setInt(2,pointDto.getPlpoint());
            ps.setString(3,pointDto.getPlcomment());
            int count = ps.executeUpdate();
            return count = 1;
        }catch (Exception e){System.out.println(e);}
        return 0;
    }
    // [2] 포인트 조회
    public List<PointDto> printPoint( int mno ){
        try{ String sql = "select * from pointlog where mno =? order by pldate desc;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ResultSet rs = ps.executeQuery();
            if( rs.next()) {
                PointDto pointDto = new PointDto();
                pointDto.setMno( rs.getInt("mno"));
                pointDto.setPlpoint(rs.getInt("plpoint"));
                pointDto.setPlcomment(rs.getString("plcomment"));
                pointDto.setPldate(rs.getString("pldate"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
