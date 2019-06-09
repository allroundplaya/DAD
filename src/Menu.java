
public class Menu {
	
	private String itemID;
	private String name;
	private int price;
	
	public Menu() {
		this.itemID = "";
		this.name = "";
		this.price = 0;
	}
	
	public Menu(String itemID, String name, int price) {
		this.itemID = itemID;
		this.name = name;
		this.price = price;
	}
	
	
	
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getItemID() {
		return this.itemID;
	}
	
	public int getPrice() {
		return this.price;
	}
	public String getName() {
		return name;
	} 
	
	public Menu getSelf() {
		return this;
	}
	
}
