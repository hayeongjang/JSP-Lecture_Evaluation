package user;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import util.DatabaseUtil;
 
public class UserDAO {
	
	// 아이디, 비밀번호를 받아서 로그인 시도
    public int login(String userID, String userPassword) {
    
      // 사용자로부터 입력받은 ID 값
      String SQL = "SELECT userPassword FROM USER WHERE userID = ?";    
      
      Connection conn = null; 
      
      // 특정 SQL 문장을 수행
      PreparedStatement pstmt = null; 
      
      // 결과 값 처리
      ResultSet rs = null;
      
      try {          
    	  // Connection 객체 초기화
          conn = DatabaseUtil.getConnection(); 
          
          // conn 객체에 prepareStatement 실행하도록 준비
          pstmt = conn.prepareStatement(SQL); 
          
          // ?에 값을 넣어줌
          pstmt.setString(1, userID);  
          
          rs = pstmt.executeQuery(); 
          if(rs.next()) { 
              if(rs.getString(1).equals(userPassword)) { 
                  return 1; // 로그인 성공
              }
              else {
                  return 0; // 비밀번호 틀림
              }
          }
          return -1;
      } catch (Exception e) {
           e.printStackTrace();
      } finally { 
        try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
        try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
        try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
     }
      return -2; //데이터 베이스 오류
     }
        
    	// 사용자 정보를 입력 받아서 회원가입 수행
        public int join(UserDTO user) {
              String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, false)";    
              Connection conn = null; 
              PreparedStatement pstmt = null; 
              ResultSet rs = null; 
              try {          
                  conn = DatabaseUtil.getConnection(); 
                  pstmt = conn.prepareStatement(SQL); 
                  pstmt.setString(1, user.getUserID());
                  pstmt.setString(2, user.getUserPassword());
                  pstmt.setString(3, user.getUserEmail());
                  pstmt.setString(4, user.getUserEmailHash());               
                  return pstmt.executeUpdate(); 
              } catch (Exception e) {
                   e.printStackTrace();
              } finally { 
                try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
                try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
                try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
             }
              return -1; //회원가입 실패
             }
        
        // 사용자 아이디를 이용해 이메일 주소 알아냄
        public String getUserEmail(String userID) {
            String SQL = "SELECT userEmail FROM USER WHERE userID = ?";    
              Connection conn = null; 
              PreparedStatement pstmt = null; 
              ResultSet rs = null; 
              try {          
                  conn = DatabaseUtil.getConnection(); 
                  pstmt = conn.prepareStatement(SQL); 
                  pstmt.setString(1, userID);
                  rs = pstmt.executeQuery();
                  if(rs.next()) {
                      return rs.getString(1);
                  }
              } catch (Exception e) {
                   e.printStackTrace();
              } finally { 
                try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
                try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
                try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
             }
              return null; // 데이터베이스 오류
        }
        
        // 사용자가 현재 이메일 인증이 되었는지 확인
        public boolean getUserEmailChecked(String userID) { 
              String SQL = "SELECT userEmailChecked FROM USER WHERE userID = ?";    
              Connection conn = null; 
              PreparedStatement pstmt = null; 
              ResultSet rs = null;
              try {          
                  conn = DatabaseUtil.getConnection(); 
                  pstmt = conn.prepareStatement(SQL); 
                  pstmt.setString(1, userID);
                  rs = pstmt.executeQuery();
                  if(rs.next()) {
                      return rs.getBoolean(1);
                  }
              } catch (Exception e) {
                   e.printStackTrace();
              } finally { 
                try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
                try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
                try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
             }
              return false; // 데이터베이스 오류
             }
        
        // 특정 사용자의 이메일 인증 수행
        public boolean setUserEmailChecked(String userID) { 
              String SQL = "UPDATE USER SET userEmailChecked = true WHERE userID = ?";    
              Connection conn = null; 
              PreparedStatement pstmt = null;
              ResultSet rs = null; 
              try {          
                  conn = DatabaseUtil.getConnection(); 
                  pstmt = conn.prepareStatement(SQL); 
                  pstmt.setString(1, userID);
                  pstmt.executeUpdate();
                  return true;
              } catch (Exception e) {
                   e.printStackTrace();
              } finally { 
                try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
                try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
                try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
             }
              return false; // 데이터베이스 오류
             }          
         }
        
 
 