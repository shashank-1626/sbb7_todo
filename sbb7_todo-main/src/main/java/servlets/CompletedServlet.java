package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToDoDAO;
import dao.ToDoDAOImpl;

@WebServlet("/CompletedServlet")
public class CompletedServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();

		int regId=Integer.
		parseInt(request.getParameter("regId"));
		int taskId=Integer.
		parseInt(request.getParameter("taskId"));
		
		ToDoDAO dao=ToDoDAOImpl.getInstance();
		boolean flag=dao.markTaskCompleted(regId, taskId);
		
		if(flag) {
			context.getRequestDispatcher("/ViewTasks.jsp").
			forward(request, response);
		}
	}
}
