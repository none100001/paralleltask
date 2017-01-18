import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class ParallelTask {
	
	public static ArrayList<Process> list;
	public static PriorityBlockingQueue<Process> pq;
	public static long midValue;
	public static long startTime;

	
	
	public static void print(){
		
		System.out.println(startTime+"th Second");
		for(Process p : pq){
			System.out.println(p.arrivalTime+" "+p.executionTime);
		}
		
		System.out.println();
	}
	
	
	
	
	
	
	
	
	static class Process implements Runnable,Comparable{
		long arrivalTime;
		long executionTime;
		
		
		
		public Process(){
			arrivalTime = -5;
			executionTime = -5;
		}
		
		
		public Process(long a,long e){
			arrivalTime = a;
			executionTime = e;
		}
		
		
		
		
		public synchronized void work(){
			if(!pq.isEmpty()){
				Process p = pq.poll();// poll dequee...
				if(p.executionTime > 0){
					if(p.arrivalTime != 0 || this.executionTime == -5){
						p.executionTime--;
						if(p.executionTime != 0)pq.add(p);
					}
					else{
						pq.add(p);
					}
				}
			}
		}
		
		
		
		
		@Override
		public void run(){
			work();
		}
		
	

		@Override
		public int compareTo(Object o) {
			// below line actually indicates heapshort..
			// it performs increasing order sort based on execution time...
			return (int)(this.executionTime - ((Process)o).executionTime);
		}
		
	
		
	}
	
	
	
	
	public static void main(String [] args) throws InterruptedException, FileNotFoundException{
		Scanner k = new Scanner(new FileReader("E:/b.txt"));
		int n = k.nextInt();
		list = new ArrayList<Process>();
		pq = new PriorityBlockingQueue<Process>();
		
		for(int c = 0;c<n;c++){
			list.add(new Process(k.nextLong(),k.nextLong()));
		}
		
		startTime = 0;
		boolean last = false;
		for(int c = 0;c<list.size();c++){
			long a = list.get(c).arrivalTime;
			long e = list.get(c).executionTime;
			
			while(true){
				
				// add new process work and for both previous and new process...
				if(startTime == a){
					Process p = new Process(a,e);
					pq.add(p); // for process adding...
					last = true;
					break; // for seeing next process..
				}
				else{
					last = false;
					print();
					Process p = new Process();
					Thread dummyThread = new Thread(p);
					dummyThread.start();
					dummyThread.join();
					startTime++;
				}
			}
		}
		
		if(last){
			print();
		}
			
	}
}
