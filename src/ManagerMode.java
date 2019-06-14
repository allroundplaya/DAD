import java.util.Scanner;

public class ManagerMode { 
	Scanner sc = new Scanner(System.in);
	private Register r;
	public ManagerMode(Register r) {
		this.r = r;
	}
	      
	public int chooseAction() {
		Scanner sc = new Scanner(System.in);
	    int action;
	    System.out.println("===================================================");
	    System.out.println("                  Manager Mode");
	    System.out.println("===================================================");
	         
	    System.out.println("���Ͻô� �۾��� ������ �ֽʽÿ�.");
	    System.out.println("1. �޴� �߰�");
	    System.out.println("2. �ý��� �α׾ƿ�");
	         
	    action = sc.nextInt();
	         
	    while(action != 1 && action != 2) {
	            System.out.println("Wrong intput!");
	            System.out.println("���Ͻô� �۾��� ������ �ֽʽÿ�.");
	            System.out.println("1. �޴� �߰�");
	            System.out.println("2. �ý��� �α׾ƿ�");
	    }
	    return action;
	}
	
	public void menuUpdate() {
		System.out.println("�޴� id, �̸�, ������ �Է��� �ּ���");
        System.out.print("�޴� id :");
        String itemID = sc.next();
        System.out.print("�̸� :");
        String name = sc.next();
        System.out.print("���� :");
        int price = sc.nextInt();
            
        this.r.makeUpdates(itemID, name, price);//�޴� ������Ʈ
        
        System.out.println("�޴� ������Ʈ�� ����Ǿ����ϴ�.");
        for(Menu m : this.r.getMenuList().getList()) {
        	System.out.printf("%-10s: %6d��    id: %5s\n", m.getName(), m.getPrice(), m.getItemID());
        }
        
        System.out.println("�������� ��ȯ�մϴ�.");
        r.toUserMode();
	}
	      
	public void run() {
	    switch(chooseAction()) {
	    case 1:
	    	menuUpdate();
	        break;
	    case 2:
	    	r.systemLogout();
	    	Scanner sc = new Scanner(System.in);
			System.out.print("Enter�� ���� ������ �����մϴ�.");
			sc.nextLine();
	    	System.out.println("�α׾ƿ��� ���������� �Ϸ�Ǿ����ϴ�.");
	    	break;
	    
	    }
	      
	      
	}

}
