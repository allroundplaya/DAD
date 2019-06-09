
public class LogIn {
	private String userID;
	LogIn(){
		this.userID="";
	}

	LogIn(String userID){
		this.userID=userID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
