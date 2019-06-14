
public class SalesLineItem {
	private Menu menu;
	private int quantity;
	
	public SalesLineItem(){
		
	}
	
	public SalesLineItem(Menu menu, int quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}
	
	
	public int calSubTotal() {
		return this.menu.getPrice() * this.quantity;
	}
	
	public Menu getMenu() {
		return this.menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
