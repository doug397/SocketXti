package br.com.red;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConselhoServidor {

	public static void main(String[] args) throws IOException {
	
		ServerSocket server= new ServerSocket(5000);
		
		while(true){
		  Socket socket=server.accept();
		  
		  // Envia uma Mensagem
		try(  PrintWriter w=new PrintWriter(  socket.getOutputStream())){
		   w.println("Aprenda Java e Seja Contratado");
		   }
		}

	}

}
