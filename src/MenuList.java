import java.io.Serializable;
import java.util.ArrayList;

public class MenuList implements Serializable {
	private static final long serialVersionUID = 3L;
	private ArrayList<Menu> list;
	
	public MenuList() {
		this.list = new ArrayList<Menu>();
		list.add(new Menu("0001", "���", 2000));
		list.add(new Menu("0002", "���", 1300));
		list.add(new Menu("0003", "������", 3500));
		list.add(new Menu("0004", "�����", 4000));
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
