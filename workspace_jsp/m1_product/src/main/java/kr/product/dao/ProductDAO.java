package kr.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	};
	
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
	
	// 상품 저장
	public void insert(ProductVO vo) throws Exception {
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
	
	// 상품의 총 갯수
	public int getCount() {
		int count = 0;
		
		return count;
	}
	
	// 상품 목록
	public List<ProductVO> getList() throws Exception {
		List<ProductVO> list = null;
		
		return list;
	}
	
	// 상품 상세 정보
	public ProductVO getProduct(int num) throws Exception {
		ProductVO vo = null;
		
		return vo;
	}
	
	// 상품 정보 수정
	public void update() throws Exception {
		
	}
	
	// 상품 정보 삭제
	public void delete() throws Exception {
		
	}
}