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
	         
	    System.out.println("원하시는 작업을 선택해 주십시오.");
	    System.out.println("1. 메뉴 추가");
	    System.out.println("2. 시스템 로그아웃");
	         
	    action = sc.nextInt();
	         
	    while(action != 1 && action != 2) {
	            System.out.println("Wrong intput!");
	            System.out.println("원하시는 작업을 선택해 주십시오.");
	            System.out.println("1. 메뉴 추가");
	            System.out.println("2. 시스템 로그아웃");
	    }
	    return action;
	}
	
	public void menuUpdate() {
		System.out.println("메뉴 id, 이름, 가격을 입력해 주세요");
        System.out.print("메뉴 id :");
        String itemID = sc.next();
        System.out.print("이름 :");
        String name = sc.next();
        System.out.print("가격 :");
        int price = sc.nextInt();
            
        this.r.makeUpdates(itemID, name, price);//메뉴 업데이트
        
        System.out.println("메뉴 업데이트가 적용되었습니다.");
        for(Menu m : this.r.getMenuList().getList()) {
        	System.out.printf("%-10s: %6d원    id: %5s\n", m.getName(), m.getPrice(), m.getItemID());
        }
        
        System.out.println("유저모드로 전환합니다.");
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
			System.out.print("Enter를 눌러 영업을 마감합니다.");
			sc.nextLine();
	    	System.out.println("로그아웃이 정상적으로 완료되었습니다.");
	    	break;
	    
	    }
	      
	      
	}

}
