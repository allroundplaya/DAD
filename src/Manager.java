import java.io.Serializable;

public class Manager implements Serializable{
	private static final long serialVersionUID = 5L;
	private String userID;
	private String PW;
	
	public Manager() {
		
	}
	
	public Manager(String userID, String PW) {
		this.setUserID(userID);
		this.setPW(PW);
	}
	
	
	
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	
}
