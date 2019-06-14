import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Sale {
	private boolean isComplete;
	private String date;
	private String time;
	private int total;
	private CashPayment cashPayment;
	private ArrayList<SalesLineItem> items;
	
	

	public Sale() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HH:mm:ss");
		
		Date time = new Date();
		
		this.isComplete = false;
		this.date = format1.format(time);
		this.time = format2.format(time);
		this.total = 0;
		this.cashPayment = null;
		this.items = new ArrayList<SalesLineItem>();
	}
	
	public void updateTotal(int subTotal) {
		this.total += subTotal;
	}
	
	public void makeNewSalesLineItem(Menu menu, int quantity) {
		SalesLineItem sli = new SalesLineItem(menu, quantity);
		int subTotal = sli.calSubTotal();
		this.updateTotal(subTotal);
		this.items.add(sli);
	}
	
	
	
	public boolean getIsComplete() {
		return isComplete;
	}
	
	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
///////////////////// »¬°Í /////////////////////////////////
//	public CashPayment getCashPayment() {
//		return this.cashPayment;
//	}
/////////////////////////////////////////////////////////
	public void setCashPayment(CashPayment cp) {
		this.cashPayment = cp;
	}

	public ArrayList<SalesLineItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<SalesLineItem> items) {
		this.items = items;
	}
	
}
