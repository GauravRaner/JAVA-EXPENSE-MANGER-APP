package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ExpenseDao;
import Model.ExpenseDto;

@WebServlet(urlPatterns = {"/addIncome"})
public class ExpenseServlet extends HttpServlet{
	private static ExpenseDao dao=new ExpenseDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		
		switch(path) {
		case "/addIncome":
			addIncome(req,resp);
			break;
		}
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


