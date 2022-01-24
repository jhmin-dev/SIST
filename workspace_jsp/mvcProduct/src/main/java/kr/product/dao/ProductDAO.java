package kr.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.product.vo.ProductVO;

public class ProductDAO {

	// 싱글턴 패턴
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	// context.xml에서 설정 정보를 읽어들여 커넥션 풀로부터 커넥션을 할당받음
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}
	
	// 자원 정리
	private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
	
	// 상품 등록
	public void registerProduct(ProductVO vo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "INSERT INTO sproduct (num, name, price, stock, origin, content) "
				+ "VALUES (sproduct_seq.NEXTVAL, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getStock());
			pstmt.setString(4, vo.getOrigin());
			pstmt.setString(5, vo.getContent());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			executeClose(null, pstmt, conn);
		}
	}
	
	// 총 상품 수
	public int getCount() throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		String sql= null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT COUNT(*) FROM sproduct";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 목록
	public List<ProductVO> getList(int startRow, int endRow) throws Exception {
		List<ProductVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM (SELECT sp.*, ROWNUM AS rnum "
				+ "FROM (SELECT * FROM sproduct ORDER BY num DESC) sp) "
				+ "WHERE rnum >= ? AND rnum <= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<ProductVO>();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setOrigin(rs.getString("origin"));
				vo.setContent(rs.getString("content"));
				vo.setReg_date(rs.getDate("reg_date"));
				list.add(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// 상품 상세 정보
	public ProductVO getProduct(int num) throws Exception {
		ProductVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM sproduct WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setNum(num);
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setOrigin(rs.getString("origin"));
				vo.setContent(rs.getString("content"));
				vo.setReg_date(rs.getDate("reg_date"));
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			executeClose(rs, pstmt, conn);
		}
		
		return vo;
	}
	
	// 상품 수정
	public void updateProduct(ProductVO vo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "UPDATE sproduct SET name=?, price=?, stock=?, origin=?, content=? WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getStock());
			pstmt.setString(4, vo.getOrigin());
			pstmt.setString(5, vo.getContent());
			pstmt.setInt(6, vo.getNum());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			executeClose(null, pstmt, conn);
		}
	}
	
	// 상품 삭제
	public void deleteProduct(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "DELETE FROM sproduct WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			executeClose(null, pstmt, conn);
		}
	}
}