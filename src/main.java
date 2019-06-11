import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
	public static void main(String args[]) {
		File menuListFile = new File("menulist.ser");
		File managerListFile = new File("managerlist.ser");
		File ledgerListFile = new File("ledgerlist.ser");
		
		MenuList menuList = new MenuList();
		ManagerList managerList = new ManagerList();
		LedgerList ledgerList = new LedgerList();
		Register register;
	
		if (menuListFile.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(menuListFile.getName());
				ObjectInputStream in = new ObjectInputStream(fis);
				menuList = (MenuList)in.readObject();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if (managerListFile.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(managerListFile.getName());
				ObjectInputStream in = new ObjectInputStream(fis);
				managerList = (ManagerList)in.readObject();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		if (ledgerListFile.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(ledgerListFile.getName());
				ObjectInputStream in = new ObjectInputStream(fis);
				ledgerList = (LedgerList)in.readObject();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		register = new Register(managerList, menuList, ledgerList);
		
		
	}
}
