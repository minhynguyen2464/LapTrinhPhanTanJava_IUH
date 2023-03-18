package RMI1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String avg[]) throws Exception{
		try {
            Registry registry = LocateRegistry.createRegistry(1099); //Open port 1099
            registry.bind("Hello", new Helloimp()); //Bind with "Hello"
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}
