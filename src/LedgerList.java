import java.util.ArrayList;

public class LedgerList {
	private ArrayList<Ledger> list;
	
	public LedgerList() {
		this.list = null;
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
