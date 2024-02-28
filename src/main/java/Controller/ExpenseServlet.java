package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ExpenseDao;
import Model.ExpenseDto;
import Model.ServiceClass;

@WebServlet(urlPatterns = {"/addIncome","/addExpense","/homePage"})
public class ExpenseServlet extends HttpServlet{
	private static ExpenseDao dao=new ExpenseDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		
		switch(path) {
		case "/addIncome":
			addIncome(req,resp);
			displayData(req, resp);
			break;
		case "/addExpense":
			addExpense(req,resp);
			displayData(req, resp);
			break;
		case "/homePage":
			displayData(req,resp);
			break;
		}
	}

	private void displayData(HttpServletRequest req, HttpServletResponse resp) {
		ServiceClass s1=new ServiceClass();
		String startPoint=s1.startPoint();
		String endPoint=s1.endPoint();
		
		String temp1=req.getParameter("startDate");
		String temp2=req.getParameter("endDate");
		
		
		
		if(temp1!=null && temp2!=null) {
			startPoint=temp1;
			endPoint=temp2;
		}
		
		ExpenseDto dto=new ExpenseDto();
		dto.setStartPoint(startPoint);
		dto.setEndPoint(endPoint);
		
		ExpenseDto data=dao.displayData(dto);
		req.setAttribute("DATA",data);
		try {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
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


