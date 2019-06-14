import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ledger implements Serializable{
	private static final long serialVersionUID = 5L;
	private String date;
	private int balance;
	private ArrayList<Sale> list;
	
	public Ledger() {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		Date time = new Date();
		
		this.date = format.format(time); 
		this.balance = 0;
		this.list = new ArrayList<Sale>();
	}
	
	public void recordSale(Sale sale) {
		this.list.add(sale);
		this.balance += sale.getTotal();
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public ArrayList<Sale> getList() {
		return list;
	}

	public void setList(ArrayList<Sale> list) {
		this.list = list;
	}

}
