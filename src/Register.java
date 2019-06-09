import java.util.ArrayList;

public class Register {
	private ManagerList managerList;
	private MenuList menuList;
	private LedgerList ledgerList;
	private Ledger ledger;
	private Sale currentSale;
	private FoodCourt foodCourt;
	private CashPayment cashPayment;
	
	
	// menu list�� db�κ��� �ҷ���.
	public Register(ManagerList managerList, MenuList menuList, LedgerList ledgerList) {
		this.managerList = managerList;
		this.menuList = menuList;
		this.ledgerList = ledgerList;
		this.ledger = null;
		this.currentSale = null;
		this.foodCourt = new FoodCourt();
		this.cashPayment = null;
	}
	
	/*
	 * Use Case 1: �ֹ� �� ����
	 */
	
	public void makeNewSale() {
		if(this.foodCourt.getIsOpened() && this.foodCourt.getIsOnSale())
			this.currentSale = new Sale();	
	}
	
	public void selectItem(String itemID, int quantity) {
		if(this.foodCourt.getIsOpened() && this.foodCourt.getIsOnSale()) {
			Menu currentMenu = menuList.getMenuById(itemID);
			currentSale.makeNewSalesLineItem(currentMenu, quantity);
		}
	}
	
	public void endSale() {
		if(this.foodCourt.getIsOpened() && this.foodCourt.getIsOnSale())
			this.currentSale.setIsComplete(true);
	}
	
	public void makePayment() {
		if(this.foodCourt.getIsOpened() && this.foodCourt.getIsOnSale()) {
			this.cashPayment = new CashPayment(this.currentSale.getTotal());
			this.cashPayment.processPayment();
			this.currentSale.setCashPayment(this.cashPayment);
			this.ledger.recordSale(this.currentSale);
		}
		
	}
	
	/*
	 * Use Case 2: �ý��� �α���
	 */
	
	public void systemLogin(String ID, String PW) {
		if(!this.foodCourt.getIsOpened()) {
			boolean isAuthenticated = this.managerList.authenticate(ID, PW);
			if(isAuthenticated) {
				this.foodCourt.setIsOpened(true);
				this.ledger = new Ledger();
			}
		}
	}
	
	//Operation2 : toUserMode()
	public void toUserMode(){
		if(this.foodCourt.getIsOpened() && !this.foodCourt.getIsOnSale()) {
				this.foodCourt.setIsOnSale(true);//user_mode�� ��ȯ
		}
	}
	
	
	/*
	 * Use Case 3: �ý��� �α׾ƿ�
	 */
	public void systemLogout(String ID, String PW) {
		if(this.foodCourt.getIsOpened() && !this.foodCourt.getIsOnSale()) {
			this.ledgerList.insertLedger(this.ledger);
			this.ledgerList.clearOutdated();
			
			this.foodCourt.setIsOpened(false);
		}
	}
	
	
	/*
	 * Use Case 4: �޴� ������Ʈ
	 */
	
	//Operation1 : toManagerMode()
	public void toManagerMode(String ID, String PW) {
		if(this.foodCourt.getIsOpened() && this.foodCourt.getIsOnSale()) {
			boolean isAuthenticated = managerList.authenticate(ID, PW);
			
			if(isAuthenticated) 
				this.foodCourt.setIsOnSale(false);
		}
	}
			
			
			
	//Operation2 : makeUpdates
	public void makeUpdates(String itemID, String info, int price) {
		if(this.foodCourt.getIsOpened() && !this.foodCourt.getIsOnSale()) {
				Menu newMenu = new Menu(itemID,info,price);//�Ÿ޴� ����
				this.menuList.addMenu(newMenu);
		}//�Ÿ޴� �����
	}
	
	
	
	
}
