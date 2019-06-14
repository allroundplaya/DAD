import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
	public static void main(String args[]) {
		String MENULIST_SER = "menulist.ser";
		String MANAGERLIST_SER = "managerlist.ser";
		String LEDGERLIST_SER = "ledgerlist.ser";
		File menuListFile = new File(MENULIST_SER);
		File managerListFile = new File(MANAGERLIST_SER);
		File ledgerListFile = new File(LEDGERLIST_SER);
		
		MenuList menuList = new MenuList();
		ManagerList managerList = new ManagerList();
		LedgerList ledgerList = new LedgerList();
		Register register;
	
		if (menuListFile.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(menuListFile.getName());
				ObjectInputStream in = new ObjectInputStream(fis);
				menuList = (MenuList)in.readObject();
				System.out.println("Menu list is loaded.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if (managerListFile.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(managerListFile.getName());
				ObjectInputStream in = new ObjectInputStream(fis);
				managerList = (ManagerList)in.readObject();
				System.out.println("Manger list is loaded.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		if (ledgerListFile.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(ledgerListFile.getName());
				ObjectInputStream in = new ObjectInputStream(fis);
				ledgerList = (LedgerList)in.readObject();
				System.out.println("Ledger list is loaded.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		register = new Register(managerList, menuList, ledgerList);
		
		InitMode i = new InitMode(register);
		
		while(i.run()) {
			UserMode u = new UserMode(register);
			while(register.getFoodCourt().getIsOnSale())	
				u.run();
		}
		
		try {
			FileOutputStream fos= new FileOutputStream(MENULIST_SER);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(register.getMenuList());
			out.close();
			System.out.println("Menu list is saved.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileOutputStream fos= new FileOutputStream(MANAGERLIST_SER);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(register.getManagerList());
			out.close();
			System.out.println("Manager list is saved.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileOutputStream fos= new FileOutputStream(LEDGERLIST_SER);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(register.getLedgerList());
			out.close();
			System.out.println("Ledger list is saved.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
