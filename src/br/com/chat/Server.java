package br.com.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextField;

public class Server {
	
	List<PrintWriter> escritores= new  ArrayList<>();
	
	public Server() {
		ServerSocket server;
		try{
		  server	= new ServerSocket(5002);
		  while(true){
			Socket socket=	server.accept();
			 new Thread(new EscutaCliente(socket)).start();
			 PrintWriter p=new PrintWriter(socket.getOutputStream());
			 escritores.add(p);
			}
		}catch (Exception e) {
		
		}
	}

	private void encaminharParaTodos(String texto){
		for(PrintWriter w:escritores){
			try{
				w.println(texto);
				w.flush();
			}catch (Exception e) {
				// TODO: handle exception
			}	
		}
	}
	private class EscutaCliente implements Runnable{
		Scanner leitor;
		public EscutaCliente(Socket socket){
			try {
				 leitor= new Scanner(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			
			try{
			String texto;
				while((texto=leitor.nextLine())!= null){
					System.out.println( texto);
					encaminharParaTodos(texto);
				}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		new Server();

	}

}
