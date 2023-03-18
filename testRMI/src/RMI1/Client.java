package RMI1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String avg[]) throws Exception{
		try {
			Registry registry = LocateRegistry.getRegistry(null);
			Hello stub = (Hello) registry.lookup("Hello");
			
			String msg = stub.prtMsg("Client");
            System.out.println("From Client "+msg);
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}
