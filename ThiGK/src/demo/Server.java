package demo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public Server(){
		try {
			Registry re = LocateRegistry.createRegistry(1099);
			re.rebind("dictonaryBind", new DictionaryObject()); //Bind with dictionaryBind
			System.out.println("SERVER IS RUNNING");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

}
