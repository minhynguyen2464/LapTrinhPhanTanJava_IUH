package demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductObject extends UnicastRemoteObject implements ProductInterface{

	protected ProductObject() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int updateProduct(int productsID, String products_name, String product_company, int product_price)
			throws RemoteException {
		// TODO Auto-generated method stub
		if(JDBCUtil.update(productsID, products_name, product_company, product_price)==1) {
			return 1;
		}
		System.out.println("SUCCESS");
		return 0;
	}



	

}
