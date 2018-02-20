package br.com.softblue.java.rmi;

import java.rmi.Naming;
import java.text.NumberFormat;
import java.util.Locale;

public class MainClient {

	public static void main(String[] args) throws Exception {
		// Criando as contas
		ContaBancaria conta1 = (ContaBancaria) Naming.lookup("rmi://localhost:1099/conta1");
		ContaBancaria conta2 = (ContaBancaria) Naming.lookup("rmi://localhost:1099/conta2");
		
		// Fazendo as operções bancárias
		conta1.depositar(2000);
		conta1.sacar(500);
		conta1.transferir(200, conta2);
		
		// Formatando a saída
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String s1 = nf.format(conta1.getSaldo());
		String s2 = nf.format(conta2.getSaldo());
		
		// Saída na tela
		System.out.println("Saldo da conta = " + s1);
		System.out.println("Saldo da conta = " + s2);
	}
}
