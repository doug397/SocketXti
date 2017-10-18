package br.com.red;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConselhoCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socekt= new Socket("127.0.0.1",5000);
		
		
	 Scanner s= new Scanner	(socekt.getInputStream());
	  System.out.println("Mensagem: "+ s.nextLine());
	  s.close();
	  
	}

}
