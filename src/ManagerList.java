
import java.io.Serializable;
import java.util.ArrayList;


public class ManagerList implements Serializable{
	private static final long serialVersionUID = 2L;
	private ArrayList<Manager> list;
	   
	public ManagerList() {
		list  = new ArrayList<Manager>();
		list.add(new Manager("owner", "1234"));
	}

	public ArrayList<Manager> getList() {
		return list;
	}

	public void setList(ArrayList<Manager> list) {
		this.list = list;
	}
	   
	public void addManager(Manager Manager) {
	      this.list.add(Manager);
	   }
	   
	   public Manager getManagerById(String itemID) {
	      Manager Manager = null;
	      for(Manager m : list) {
	         if (m.getUserID() == itemID) {
	            Manager = m;
	            break;
	         }
	      }
	      return Manager;
	   }
	   
	   public boolean authenticate(String ID, String PW) {
		   Manager m = null;
		   m = this.getManagerById(ID);
		   if (m == null) return false;
		   else {
			   if(m.getPW() != PW) return false;
			   else return true;
		   }
		   
	   }
	
	
	
}

