package demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
	public int updateProduct(int productsID, String products_name, String product_company, int product_price) throws RemoteException; 
}
