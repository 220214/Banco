package view;

import java.util.concurrent.Semaphore;

import controller.Banco;

public class BancoPrincipal {

	public static void main(String[] args) {
		Semaphore b = new Semaphore (1);
		Semaphore c= new Semaphore (1);
		for ( int i =0; i< 20; i++) {
			Thread BB= new Banco (b,c);
			BB.start();
			
		}

	}

	
}
