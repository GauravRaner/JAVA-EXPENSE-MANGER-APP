<%@ page import="Model.ExpenseDto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta charset="ISO-8859-1">
    <title>HOME PAGE</title>
</head>
<body style="background-color: #e3d5ca">
    <div align="center" style="border: 1px solid blue; width: 500px; margin: 30px auto; padding: 30px;background-color: #a4c3b2">
        <h2>EXPENSE MANAGER</h2>
        <div style="margin-top: 30px">
            <a href="addIncome.html"><button class="btn btn-success">ADD INCOME</button></a>
            <a href="addExpense.html"><button class="btn btn-danger">ADD EXPENSE</button></a><br><br><br><br>
            <a><button class="btn btn-primary">TRANSACTIONS</button></a>
        </div>
        <div style="margin-top: 30px;">
            <div>
                <form action="homePage" method="post">
                	<div style="display: flex;margin-bottom: 5px"><span style="margin-left: 30px">From</span><span style="margin-left: 135px">To</span></div>
                    <input type="date" name="startDate" class="btn btn-light border border-primary">
                    <input type="date" name="endDate" class="btn btn-light border border-primary"> 
                    <input type="submit" value="FIND" class="btn btn-primary">
                </form>
            </div>
            <table style="margin-top: 30px;background-color: #ccd5ae" class=" btn-light border border-primary" border="2px ">
                <tr >
                    <th style="padding: 10px;">TOTAL INCOME</th>
                    <th style="padding: 10px;">TOTAL EXPENSE</th>
                    <th style="padding: 10px;">BALANCE</th>
                </tr>
                <tr>
                    <% ExpenseDto dto = (ExpenseDto) request.getAttribute("DATA"); %>
                    <% if (dto != null) { %>
                        <td style="padding: 5px 30px ;"><%= dto.getTotalIncome() %></td>
                        <td style="padding: 5px 30px;"><%= dto.getTotalExpense() %></td>
                        <td style="padding: 5px 30px;"><%= dto.getBalance() %></td>
                    <%} else {%>
                        <td style="padding: 5px 30px ;">0</td>
                        <td style="padding: 5px 30px ;">0</td>
                        <td style="padding: 5px 30px ;">0</td>
                    <%} %>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
