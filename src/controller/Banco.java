package controller;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

public class Banco extends Thread{
	private Semaphore b ;
	private Semaphore c;
	int conta;
	int valor;
	int deposito;
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
		 valor = (int )((Math.random()*100 )+100);
		conta = (int)((Math.random ()*100000)+ 100000);
	deposito = (int)((Math.random()* 100)+ 1000);		
		System.out.println(" Deposito -----> Conta : " + conta + "  Saldo : "+ valor +" -->Deposito : " + deposito  );
		
	}
	private void Saque () {
		int valor1 = valor + deposito;
		System.out.println(" SAQUE ----> Conta : " + conta  + " Saldo : "+valor1);
		int saque = (int)((Math.random()*12)+ 100);
		System.out.println(" Valor de saque --> "+ saque );
		System.out.println(" ");
	}
}