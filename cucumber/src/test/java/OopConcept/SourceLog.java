package OopConcept;

public class SourceLog {
private String userid;
private String password;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void LogIn(String userid,String password) {
	System.out.println(userid);
	System.out.println(password);
}
	
}


