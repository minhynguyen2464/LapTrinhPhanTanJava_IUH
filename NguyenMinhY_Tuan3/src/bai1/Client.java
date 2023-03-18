package bai1;
import java.rmi.*;
import java.io.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MyRemoteInterface m = (MyRemoteInterface)Naming.lookup("rmi://localhost/MsgService");
			System.out.println("Enter msg: ");
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
			String msg = inFromClient.readLine();
			String clientInfo = "client1";
			System.out.println(m.sendMessenge(msg, clientInfo));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
