import java.util.ArrayList;
import java.util.Scanner;

public class UserMode{
	private Register r;
	public UserMode(Register r) {
		this.r = r;
	}
	
	public int chooseAction() {
		Scanner sc = new Scanner(System.in);
		int action;
		System.out.println("===================================================");
		System.out.println("                    User Mode");
		System.out.println("==================================================");
		
		System.out.println("원하시는 작업을 선택해 주십시오.");
		System.out.println("1. 새로운 주문");
		System.out.println("2. 매니저 모드");
		
		action = sc.nextInt();
		
		while(action != 1 && action != 2) {
			System.out.println("Wrong intput!");
			System.out.println("원하시는 작업을 선택해 주십시오.");
			System.out.println("1. 새로운 주문");
			System.out.println("2. 매니저 모드");
		}
		return action;
	}
	
	public void chooseItem() {
		System.out.println("판매 중인 메뉴:");
		for(Menu m : this.r.getMenuList().getList()) {
			System.out.printf("%-10s: %6d원    id: %5s\n", m.getName(), m.getPrice(), m.getItemID());
		}
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("\n주문하시고자 하는 메뉴의 id와 수량을 입력하고, 주문 완료를 원할시 \"end\"를 입력해주세요."
				+ "\n(ex. 돈가스 2개 ---> 0003 2)");
		
		
		while(true) {
			System.out.print(">> ");
			String id = sc.next();
			if(id.equals("end")) {
				this.terminate();
				r.endSale();
				break;
			}
			int quantity = sc.nextInt();
		
			this.r.selectItem(id, quantity);
		}
	}
	
	public void terminate() {
		ArrayList<SalesLineItem> li = this.r.getCurrentSale().getItems();
		for(SalesLineItem sli : li) {
			System.out.printf("%-10s %2d개 %7d원\n", sli.getMenu().getName(), sli.getQuantity(), sli.calSubTotal());
		}
		System.out.println("총 금액: " + r.getCurrentSale().getTotal() + "원");
	}
	public void pay() {
		System.out.println("해당하는 금액을 넣어주세요.");
		System.out.println(".\n.\n.\n결제가 완료되었습니다.");
		this.r.makePayment();
	}
	
	public void authenticate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===================================================");
		System.out.println("                        관리자 인증");
		System.out.println("===================================================");
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		while(!r.toManagerMode(id, pw)) {
			System.out.println("일치하는 ID 또는 PW가 없습니다.");
			System.out.print("ID: ");
			id = sc.next();
			System.out.print("PW: ");
			pw = sc.next();
		}
		ManagerMode m = new ManagerMode(r);
		m.run();
//		System.out.println("매니저 모드로 바뀌었습니다.");
	}
	
	public void run() {
		while(r.getFoodCourt().getIsOnSale()) {
			switch(this.chooseAction()) {
			case 1:
				r.makeNewSale();
				chooseItem();
				pay();
				run();
				break;
			
			case 2:
				authenticate();
				break;
			default: 
				break;
			}
		
		}
		
	}
}
