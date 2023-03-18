package bai2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 	Registry registry = LocateRegistry.getRegistry(null); 
			 	SortingRemoteInterface sort = (SortingRemoteInterface) registry.lookup("sort");	
			 	String message = "4,6,3,1,2";
	            /*String result = sort.sorting(message);
	            System.out.println(result);*/
			 	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
