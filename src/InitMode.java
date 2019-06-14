import java.util.Scanner;

public class InitMode{
	private Register r;
	
	public InitMode(Register r) {
		this.r = r;
	}
	
	public boolean login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==================================================");
		System.out.println("                   Kiosk Login");
		System.out.println("==================================================");
		System.out.println("Enter \"end\" to terminate");
		System.out.print("ID: ");
		String id = sc.next();
		if(id.equals("end"))
			return false;
		System.out.print("PW: ");
		String pw = sc.next();
		
		while(!r.systemLogin(id, pw)) {
			System.out.println("일치하는 ID 또는 PW가 없습니다.");
			System.out.print("ID: ");
			id = sc.next();
			System.out.print("PW: ");
			pw = sc.next();
		}
		
		return true;
	}
	
	public void toUserMode() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter를 눌러 영업을 시작합니다.");
		sc.nextLine();
		r.toUserMode();
	}
	
	public boolean run() {
		if(!login())
			return false;
		toUserMode();
		UserMode u = new UserMode(this.r);
		u.run();
		return true;
	}
}
