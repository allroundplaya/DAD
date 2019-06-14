import java.io.Serializable;
import java.util.ArrayList;

public class LedgerList implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Ledger> list;
	
	public LedgerList() {
		this.list = new ArrayList<Ledger>();
	}
	
	public LedgerList(ArrayList<Ledger> list) {
		this.list = list;
	}
	
	public void insertLedger(Ledger ledger) {
		this.list.add(ledger);
	}
	public void clearOutdated() {
		if(this.list.size() > 30) {
			this.list.remove(0);
		}
	}
	
	public Ledger getLedgerByDate(String date) {
		Ledger ledger = null;
		for(Ledger l : this.list) {
			if(date == l.getDate())
				ledger = l;
		}
		return ledger;
	}
			
}
