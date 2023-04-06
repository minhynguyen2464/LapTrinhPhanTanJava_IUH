package baitap;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Client {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			int loop = 1;
			Registry registry = LocateRegistry.getRegistry(null);
			HelloInterface msg = (HelloInterface)registry.lookup("send");
			//Menu
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("-------------------------------");
				System.out.println("1. Tra tu dien");
				System.out.println("2. Them tu"); 
				System.out.println("3. Xoa tu"); 
				System.out.println("4. List word"); //Not done
				System.out.println("0. Exit");
				System.out.print("Please choose option: ");
				int option = sc.nextInt();
				switch(option) {
					//List tu
					case 0:{
						loop=0;
						break;
					}
					//Tra tu dien
					case 1:{
						
						System.out.print("Please enter words: ");
						BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
						String clientSend = inFromClient.readLine();
						String result = msg.selectWord(clientSend);
						System.out.println("Vietnamese is: "+result);
						break;
					}
					//Them tu
					case 2:{
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
					case 3:{
						System.out.print("Please choose the word you want to delete: ");
						int index = sc.nextInt();
						msg.deleteWord(index);
						System.out.println("DELETE SUCCESSFULLY");
						break;
					}
					case 4:{
						ArrayList<MyDictionary> myList = msg.listWord();
						//ArrayList<MyDictionary> myList = new ArrayList<MyDictionary>();
						//myList = msg.listWord();
						System.out.println("------------------------------------------------");
						for(MyDictionary result:myList){
							System.out.println(result.getWord_key()+" "+result.getEnglish()+" "+result.getVietnamese());
						}
						break;
					}
				}
			}
			while(loop!=0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}


