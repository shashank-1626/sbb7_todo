<%@page import="beans.Task"%>
<%@page import="java.util.List"%>
<%@ page import="dao.ToDoDAO" %>
<%@ page import="dao.ToDoDAOImpl" %>
<!-- welcome strip -->
<p align='right'>
	Welcome 
	<% 
	ToDoDAO dao=ToDoDAOImpl.getInstance();
	int regId=Integer.parseInt(
		session.getAttribute("regId").toString());
	String fname=dao.getFnameByRegId(regId);
	%>
	<%=fname%>,
	<a href="./LogoutServlet">Logout</a>
</p>

<!-- Add Task Form -->
<table align="center" width="20" border="1">
	<form method="post" action="./AddTaskServlet">
		<tr>
			<th>Task Name</th>
			<td><input type="text" name="taskName"></td>
		</tr>
		<tr>
			<th>Task Date</th>
			<td><input type="text" name="taskDate" 
							placeholder="dd-mm-yyyy"></td>
		</tr>
		<tr>
			<th>Task Status</th>
			<td>
				<select name="taskStatus">
					<option value="1">Not Yet Started</option>
					<option value="2">In Progress</option>
					<option value="3">Completed</option>
				</select>
			</td>
		</tr>
		<tr>
			<th><input type="submit" name="submit" value="Add Task"></th>
			<td><input type="reset" name="reset" value="Clear"></td>
		</tr>		
	</form>
</table>

<!-- View Tasks Page -->
<%
	List<Task> tasks=dao.findAllTasksByRegId(regId);
%>
<table align='center' width="60" border="1">
	<tr>
		<th>TaskID</th>
		<th>TaskName</th>
		<th>TaskDate</th>
		<th>TaskStatus</th>
		<th></th>
	</tr>
	<%
		for(Task task:tasks) {
			int taskId=task.getTid();
			String taskName=task.getTaskname();
			String taskDate=task.getTaskdate();
			int taskStatus=task.getTaskstatus();
	%>
	<% 
		if(taskStatus!=3) {
	%>
		<tr>
			<td><%=taskId%></td>
			<td><%=taskName%></td>
			<td><%=taskDate%></td>
			<td><%=taskStatus%></td>
			<td><a href="./CompletedServlet?regId=<%=regId%>&taskId=<%=taskId%>">Completed</a></td>
		</tr>
	<%
		} else {
	%>
		<tr style="text-decoration:line-through; ">
			<td><%=taskId%></td>
			<td><%=taskName%></td>
			<td><%=taskDate%></td>
			<td><%=taskStatus%></td>
			<td>Completed</td>
		</tr>
	<%
	} 
	%>
	<%
	}
	%>
</table>
