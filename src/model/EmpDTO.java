package model;

import java.sql.Date;

public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;

	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpDTO [empno=").append(empno).append(", ename=").append(ename).append(", job=").append(job)
				.append(", mgr=").append(mgr).append(", hiredate=").append(hiredate).append(", sal=").append(sal)
				.append(", comm=").append(comm).append(", deptno=").append(deptno).append("]");
		return builder.toString();
	}


	public EmpDTO(){
		
	}
	
	
	public EmpDTO(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

}
