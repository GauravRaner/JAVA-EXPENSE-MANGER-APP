package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ExpenseDao;
import Model.ExpenseDto;

@WebServlet(urlPatterns = {"/addIncome","/addExpense"})
public class ExpenseServlet extends HttpServlet{
	private static ExpenseDao dao=new ExpenseDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		
		switch(path) {
		case "/addIncome":
			addIncome(req,resp);
			break;
		case "/addExpense":
			addExpense(req,resp);
			break;
		}
	}

	private void addExpense(HttpServletRequest req, HttpServletResponse resp) {
		double expenseAmount=Double.parseDouble(req.getParameter("expenseAmount"));
		String expenseCategory=req.getParameter("expenseCategory");
		String expenseType=req.getParameter("expenseType");
		String expenseNote=req.getParameter("expenseNote");
		String expenseDate=req.getParameter("expenseDate");
		String expenseTime=req.getParameter("expenseTime");
		
		ExpenseDto dto=new ExpenseDto();
		dto.setExpense(expenseAmount);
		dto.setCategory(expenseCategory);
		dto.setPaymentMethod(expenseType);
		dto.setNotes(expenseNote);
		dto.setPaymentDate(expenseDate);
		dto.setPaymentTime(expenseTime);
		
		dao.addExpense(dto);
	}

	private void addIncome(HttpServletRequest req, HttpServletResponse resp) {
		String amount=req.getParameter("incomeAmount");
		String incomeCategory=req.getParameter("incomeCategory");
		String incomeType=req.getParameter("incomeType");
		String incomeNote=req.getParameter("incomeNote");
		String incomeDate=req.getParameter("incomeDate");
		String incomeTime=req.getParameter("incomeTime");
		
		double incomeAmount=Double.parseDouble(amount);
		
		ExpenseDto dto=new ExpenseDto();
		dto.setIncome(incomeAmount);
		dto.setCategory(incomeCategory);
		dto.setPaymentMethod(incomeType);
		dto.setNotes(incomeNote);	
		dto.setPaymentDate(incomeDate);
		dto.setPaymentTime(incomeTime);
		
		dao.addIncome(dto);

	}
}


