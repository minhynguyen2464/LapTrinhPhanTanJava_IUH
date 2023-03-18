package bai2;
import java.rmi.*;

public interface SortingRemoteInterface extends Remote{
	public int[] stringToIntArray(String number) throws RemoteException;
	public String sorting(String number) throws RemoteException;
	public String intToString(int[] number) throws RemoteException;
}
