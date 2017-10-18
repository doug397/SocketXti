package br.com.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cliente extends JFrame {
	
	 Socket socket;
	 PrintWriter escritor;
	 
	 JTextField textoParaEnviar;
	 String nome;
	 
	 public Cliente(String nome){
		 super("Chat :" +nome);
		 this.nome=nome;
		 
		 Font fonte= new Font("Serif",Font.PLAIN,26);
	
		 
		 textoParaEnviar= new JTextField();
		 JButton botao= new JButton("Enviar");
		 
		 textoParaEnviar.setFont(fonte);
		 botao.setFont(fonte);
		 botao.addActionListener(new EnviarListener());
		 
		 Container envio= new JPanel();
		 envio.setLayout(new BorderLayout());
		 envio.add(BorderLayout.CENTER, textoParaEnviar);
		 envio.add(BorderLayout.EAST,botao);
		 getContentPane().add(BorderLayout.SOUTH, envio);
		 
		 
		 configurarRede();
		 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(500,90);
		 setVisible(true);
		 
		
	 }
	 
	 private class EnviarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			escritor.println(nome+" : "+textoParaEnviar.getText());
			escritor.flush();
			textoParaEnviar.setText("");
			textoParaEnviar.requestFocus();
		}
		 
	 }
	
	private void configurarRede(){
		try{
		 socket= new Socket("127.0.0.1",5002);
		 escritor=new PrintWriter(socket.getOutputStream());
		}catch (Exception e) {
			
		}
	}
		
	public static void main(String[] args) {
	   new Cliente("Douglas");
		 new Cliente("Larissa");
	}

}
