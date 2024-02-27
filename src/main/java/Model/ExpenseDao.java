package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseDao {
	private static Connection connection=CreateConnection.createConnection();
	private static String addIncome="insert into expense_manager values (?,?,?,?,?,?,?,?,?,?,?)";
	private static String totalIncome="select total_income,balance,total_expense from expense_manager";
	private static double income=0,balance=0,expense=0;
	
	private void fetchTotalIncomeAndBalance() {
		try {
			PreparedStatement pstmt=connection.prepareStatement(totalIncome);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				income=rs.getDouble(1);
				balance=rs.getDouble(2);
				expense=rs.getDouble(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addIncome(ExpenseDto dto) {
		fetchTotalIncomeAndBalance();
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
			pstmt.setDouble(9, dto.getIncome()+income);
			pstmt.setDouble(10, dto.getExpense()+expense);
			pstmt.setDouble(11, dto.getIncome()+balance);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void addExpense(ExpenseDto dto) {
		fetchTotalIncomeAndBalance();
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
			pstmt.setDouble(9, dto.getIncome()+income);
			pstmt.setDouble(10, dto.getExpense()+expense);
			pstmt.setDouble(11, income-(expense+dto.getExpense()));
			
			int count=pstmt.executeUpdate();
			System.out.println(count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
