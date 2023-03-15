package controller;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

public class Banco extends Thread{
	private Semaphore b ;
	private Semaphore c;
	int conta;
	int valor;
	public Banco(Semaphore b, Semaphore c) {
		this.b=b;
		this.c=c;
		}
	public void run () {
		try {
			b.acquire();
			Saldo();
			c.acquire();
			Saque();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			b.release();
			c.release();
		}
			
			
	}
	private void Saldo() {
		 valor = (int )((Math.random()*10 )+100);
		conta = (int)((Math.random ()*100000)+ 100000);
		System.out.println("Saldo-----> Conta : " + conta + "saldo : "+ valor   );
		
	}
	private void Saque () {
		System.out.println(" SAQUE ----> Conta : " + conta  + " Saldo : "+valor);
		double saque= Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para sacar---->saldo: " + valor ));
		System.out.println(" ");
	}
}