package baitap;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Registry registry = LocateRegistry.getRegistry(null);
			HelloInterface msg = (HelloInterface)registry.lookup("send");
			//Menu
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Hien thi danh sach tu dien");
			System.out.println("2. Tra tu dien");
			System.out.println("3. Them tu"); //Not done
			System.out.println("4. Xoa tu"); //Not done
			System.out.print("Please choose option: ");
			int option = sc.nextInt();
			switch(option) {
				//List tu
				case 1:{
					msg.listWord();
					break;
				}
				//Tra tu dien
				case 2:{
					System.out.print("Please enter words: ");
					BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
					String clientSend = inFromClient.readLine();
					String result = msg.sendMessenge(clientSend);
					System.out.println("Vietnamese is: "+result);
					break;
				}
				//Them tu
				case 3:{
					System.out.print("Please enter english word: ");
					BufferedReader inEnglish = new BufferedReader(new InputStreamReader(System.in));
					String newEnglish = inEnglish.readLine();
					System.out.print("Please enter vietnamese word: ");
					BufferedReader inVietnamese = new BufferedReader(new InputStreamReader(System.in));
					String newVietnamese = inVietnamese.readLine();
					msg.insertWord(newVietnamese, newEnglish);
					System.out.println("ADD SUCCESFULLY");
					break;
				}
				//Xoa tu
				case 4:{
					msg.listWord();
					System.out.print("Please choose the word you want to delete: ");
					int index = sc.nextInt();
					msg.deleteWord(index);
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}


