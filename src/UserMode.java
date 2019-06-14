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
		
		System.out.println("���Ͻô� �۾��� ������ �ֽʽÿ�.");
		System.out.println("1. ���ο� �ֹ�");
		System.out.println("2. �Ŵ��� ���");
		
		action = sc.nextInt();
		
		while(action != 1 && action != 2) {
			System.out.println("Wrong intput!");
			System.out.println("���Ͻô� �۾��� ������ �ֽʽÿ�.");
			System.out.println("1. ���ο� �ֹ�");
			System.out.println("2. �Ŵ��� ���");
		}
		return action;
	}
	
	public void chooseItem() {
		System.out.println("�Ǹ� ���� �޴�:");
		for(Menu m : this.r.getMenuList().getList()) {
			System.out.printf("%-10s: %6d��    id: %5s\n", m.getName(), m.getPrice(), m.getItemID());
		}
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("\n�ֹ��Ͻð��� �ϴ� �޴��� id�� ������ �Է��ϰ�, �ֹ� �ϷḦ ���ҽ� \"end\"�� �Է����ּ���."
				+ "\n(ex. ������ 2�� ---> 0003 2)");
		
		
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
			System.out.printf("%-10s %2d�� %7d��\n", sli.getMenu().getName(), sli.getQuantity(), sli.calSubTotal());
		}
		System.out.println("�� �ݾ�: " + r.getCurrentSale().getTotal() + "��");
	}
	public void pay() {
		System.out.println("�ش��ϴ� �ݾ��� �־��ּ���.");
		System.out.println(".\n.\n.\n������ �Ϸ�Ǿ����ϴ�.");
		this.r.makePayment();
	}
	
	public void authenticate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===================================================");
		System.out.println("                        ������ ����");
		System.out.println("===================================================");
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		while(!r.toManagerMode(id, pw)) {
			System.out.println("��ġ�ϴ� ID �Ǵ� PW�� �����ϴ�.");
			System.out.print("ID: ");
			id = sc.next();
			System.out.print("PW: ");
			pw = sc.next();
		}
		ManagerMode m = new ManagerMode(r);
		m.run();
//		System.out.println("�Ŵ��� ���� �ٲ�����ϴ�.");
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
