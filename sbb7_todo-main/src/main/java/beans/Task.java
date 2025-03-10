package beans;

import java.util.Objects;

public class Task {
	private int tid;
	private String taskname;
	private String taskdate;
	private int taskstatus;
	private int regid;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int tid, String taskname, String taskdate, int taskstatus, int regid) {
		super();
		this.tid = tid;
		this.taskname = taskname;
		this.taskdate = taskdate;
		this.taskstatus = taskstatus;
		this.regid = regid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskdate() {
		return taskdate;
	}
	public void setTaskdate(String taskdate) {
		this.taskdate = taskdate;
	}
	public int getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(int taskstatus) {
		this.taskstatus = taskstatus;
	}
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	@Override
	public String toString() {
		return "Task [tid=" + tid + ", taskname=" + taskname + ", taskdate=" + taskdate + ", taskstatus=" + taskstatus
				+ ", regid=" + regid + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(regid, taskdate, taskname, taskstatus, tid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return regid == other.regid && Objects.equals(taskdate, other.taskdate)
				&& Objects.equals(taskname, other.taskname) && taskstatus == other.taskstatus && tid == other.tid;
	}
	
	
}
