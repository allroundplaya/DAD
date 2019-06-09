import java.io.Serializable;
import java.util.ArrayList;

public class MenuList implements Serializable {
	private ArrayList<Menu> list;
	
	public MenuList() {
		this.list = null;
	}
	
	public MenuList(ArrayList<Menu> list) {
		this.list = list;
	}
	
	public void addMenu(Menu menu) {
		this.list.add(menu);
	}
	
	public Menu getMenuById(String itemID) {
		Menu menu = null;
		for(Menu m : this.list) {
			if (m.getItemID() == itemID) {
				menu = m;
				break;
			}
		}
		return menu;
	}
	
	
	public ArrayList<Menu> getList() {
		return this.list;
	}

	public void setList(ArrayList<Menu> list) {
		this.list = list;
	}
	
	
	
//	public int getPriceById(String itemID) {
//		int price = 0;
//		Menu menu = null;
//		for (Menu m : this.getList()) {
//			if(itemID == m.getItemID()) {
//				price = m.getPrice();
//				break;
//			}
//		}
//		
//		return price;
//	}
	

	
	
}
