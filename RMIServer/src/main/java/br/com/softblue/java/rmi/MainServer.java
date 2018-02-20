package br.com.softblue.java.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {

	public static void main(String[] args) throws Exception {
		ContaBancaria conta1 = new ContaBancariaImpl();
		
		ContaBancaria conta2 = new ContaBancariaImpl();
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		registry.rebind("conta1", conta1);
		registry.rebind("conta2", conta2);
		
		System.out.println("Aguardando requisições...");
	}
}
