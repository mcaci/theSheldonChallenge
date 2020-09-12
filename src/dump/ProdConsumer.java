package dump;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author nikiforos
 * 
 * int elemento;
 * lock.lock();
 * try {
 * while(contatore==0) non_vuoto.await(); // cond
 * do_work...
 * non_pieno.signal(); // altra cond
 * } finally { lock.unlock(); }
 *
 * int elemento;
 * lock.lock();
 * try {
 * while(contatore==0) non_pieno.await(); // cond
 * do_work...
 * non_vuoto.signal(); // altra cond
 * } finally { lock.unlock(); }
 */

class P { 
	int n = 0; 
	boolean valueSet = false;
	Lock lock = new ReentrantLock();
	
	int get() {
		return n;
	} 
	
	void put(int n, String s) {
		lock.lock();
		this.n = n; 
		System.out.println("<" + s + ", " + get() + ">");
		lock.unlock();
		valueSet = true;
	} 
}

class Producer implements Runnable { 
	P p; String s; int i = 0;
	Producer(P p, String s) { 
		this.p = p; this.s = s;
		new Thread(this, "Producer").start(); 
	} 

	public void run() {
		while (i < 10) {
			if(!p.valueSet){
				p.put(i, s);
				i++;
			}
		}
	} 
}

class Consumer implements Runnable { 
	P p; P p1; int i = 0;
	Consumer(P p, P p1) { 
		this.p = p;
		this.p1 = p1;
		new Thread(this, "Consumer").start(); 
	} 

	public void run() {
		while (i < 10) {

			if(p.valueSet && p1.valueSet){
//				p.lock.lock(); p1.lock.lock();
				System.out.println("A: " + p.get());
				System.out.println("B: " + p1.get());
				p.valueSet = false;
				p1.valueSet = false;
//				p.lock.unlock(); p1.lock.unlock();
				i++;
			}
		}
	} 
}

public class ProdConsumer {
	public static void main(String args[]) { 
		P p = new P(); P p1 = new P(); 
		new Producer(p, "a");
		new Producer(p1, "b");
		new Consumer(p, p1);
//		System.out.println("Press Control-C to stop.");
//		System.exit(0);
	} 
}
