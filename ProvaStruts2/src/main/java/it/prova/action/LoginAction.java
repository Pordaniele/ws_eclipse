package it.prova.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	
	@Override
	public String execute() throws Exception {
		if("pankaj".equals(getName()) && "admin".equals(getPwd()))
		return "SUCCESS";
		else return "ERROR";
	}

	private String name;
	private String pwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}