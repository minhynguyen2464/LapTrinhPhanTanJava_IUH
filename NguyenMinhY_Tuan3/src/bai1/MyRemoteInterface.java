package bai1;
import java.rmi.*;

public interface MyRemoteInterface extends Remote{
	public String sendMessenge(String messenge, String clientInfo) throws RemoteException;
}
