package dao;

import java.util.List;

import beans.Register;
import beans.Task;

public interface ToDoDAO {
	public int register(Register register);
	public int login(String email, String pass);
	public boolean addTask(Task task, int regid);
	public List<Task> findAllTasksByRegId(int regid);
	public boolean markTaskCompleted(int regid, int taskid);
	public String getFnameByRegId(int regId);
}
