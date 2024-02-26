package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpenseDao {
	private static Connection connection=CreateConnection.createConnection();
	private static String addIncome="insert into expense_manager values (?,?,?,?,?,?,?,?,?,?,?)";
	
	public void addIncome(ExpenseDto dto) {
		try {
			PreparedStatement pstmt=connection.prepareStatement(addIncome);
			pstmt.setInt(1, 0);
			pstmt.setDouble(2,dto.getIncome());
			pstmt.setDouble(3, dto.getExpense());
			pstmt.setString(4, dto.getCategory());
			pstmt.setString(5, dto.getPaymentMethod());
			pstmt.setString(6, dto.getNotes());
			pstmt.setString(7, dto.getPaymentDate());
			pstmt.setString(8, dto.getPaymentTime());
			pstmt.setDouble(9, dto.getIncome());
			pstmt.setDouble(10, dto.getExpense());
			pstmt.setDouble(11, dto.getIncome());
			
			int count=pstmt.executeUpdate();
			System.out.println(count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
