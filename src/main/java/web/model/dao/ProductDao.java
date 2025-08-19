package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.ProductDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends Dao{

    // [1-1] 제품 등록
    public int createProduct(ProductDto productDto ){
        try{// 1. SQL 작성
            String sql = "INSERT INTO product (pname, pprice, pcomment, plat, plng, mno) VALUES( ?, ?, ?, ?, ?, ?)";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS); // (1) PK 리턴 설정
            // 3. SQL 매개변수 대입
            ps.setString(1,productDto.getPname());
            ps.setInt(2,productDto.getPprice());
            ps.setString(3,productDto.getPcomment());
            ps.setDouble(4,productDto.getPlat());
            ps.setDouble(5,productDto.getPlng());
            ps.setInt(6,productDto.getMno());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1){
                // (2) 등록된 레코드의 PK값 조회
                ResultSet rs = ps.getGeneratedKeys();
                // (3) 등록된 레코드의 첫번째 pk값 반환( 생성된 pno )
                if( rs.next() ) return rs.getInt(1);
            }
        }catch (Exception e){System.out.println(e);}
        return 0; // 실패시 0 반환

    } // m end

    // [1-2] 제품 이미지 등록
    public boolean createProductImage( int pno , String fileName ){
        try{
            String sql = "insert into productimg( pimgname , pno ) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,fileName);
            ps.setInt(2,pno);
            return ps.executeUpdate() == 1;
        }catch (Exception e){System.out.println(e);}
        return false;
    }

    // [2] 제품 전체 조회
    public List<ProductDto> getAllProduct(){
        List<ProductDto> list = new ArrayList<>();
        try{// 1. SQL 작성
            String sql = "select * from product";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            while( rs.next() ){
                ProductDto productDto = new ProductDto();
                productDto.setPno(rs.getInt("pno"));
                productDto.setPname(rs.getString("pname"));
                productDto.setPprice(rs.getInt("pprice"));
                productDto.setPcomment(rs.getString("pcomment"));
                productDto.setPdate(rs.getString("pdate"));
                productDto.setPlat(rs.getDouble("plat"));
                productDto.setPlng(rs.getDouble("plng"));
                productDto.setMno(rs.getInt("mno"));
                list.add( productDto );
            }
        }catch (Exception e){System.out.println(e);}
        return list;
    } // m end

    // [2-2] 특정한 제품의 제품이미지명 전체 조회
    public List<String> getProductImages( int pno ){
        List<String> list = new ArrayList<>();
        try{// 1. SQL 작성
            String sql = "select * from productimg where pno = ? ";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,pno);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            while( rs.next() ){
                String pimgname = rs.getString("pimgname");
                list.add(pimgname);
            }
        }catch (Exception e){System.out.println(e);}
        return list;
    } // m end

    // [3-1] 개별 제품 조회
    public ProductDto getProduct(int pno){
        try{// 1. SQL 작성
            String sql = "select * from product where pno = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,pno);
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
                 // if( rs.next() ) 레코드1개조회 vs while(rs.next()) 레코드 여러개조회
            if( rs.next() ){
                ProductDto productDto = new ProductDto();
                productDto.setPno(rs.getInt("pno"));
                productDto.setPname(rs.getString("pname"));
                productDto.setPprice(rs.getInt("pprice"));
                productDto.setPcomment(rs.getString("pcomment"));
                productDto.setPdate(rs.getString("pdate"));
                productDto.setPlat(rs.getDouble("plat"));
                productDto.setPlng(rs.getDouble("plng"));
                productDto.setMno(rs.getInt("mno"));
                return productDto; // dto 반환
            }
        }catch (Exception e){System.out.println(e);}
        return null;
    } // m end


} // class end







































