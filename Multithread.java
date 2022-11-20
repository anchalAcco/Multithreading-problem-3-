package asses;
import java.util.*;



public class Multithread extends Thread  {
	static ArrayList<String> list = new ArrayList<String>();
	 
	Multithread(){
		//this.list=list;
		 for (int i=0;i<10;i++) {
				list.add("m");
				list.add("f");
				}
	}
	  synchronized void meet(Multithread m) {
		Random random=new Random();
                while(list.size()!=0) {
	  
	    		int x1=random.nextInt(20);
	    		int y1=random.nextInt(20);
	    	   if(list.get(x1)=="m" && list.get(y1)=="m")
	    	   {
	    		   list.remove(x1);
	    		   list.remove(y1);
	    		   System.out.println("Thread " + Thread.currentThread().getId() + " is running");
	    		   System.out.println(x1+" killed "+y1);
	    	   }
	    	   if(list.get(x1)=="f" && list.get(y1)=="f")
	    	   {
	    		   int k = random.nextInt(2);
	    		   if(k==0)
	    		   list.remove(x1);
	    		   else
	    			   list.remove(y1);
	    		   System.out.println("Thread " + Thread.currentThread().getId() + " is running");
	    		  // System.out.println(random +" is killed");
	    	   }
	    	   
	    	   if((list.get(x1)=="m" && list.get(y1)=="f") || (list.get(x1)=="f" && list.get(y1)=="m"))
	    	   {
	    		   System.out.println("Thread " + Thread.currentThread().getId() + " is running");
	    	   
	    		   int g1 = random.nextInt(2);
	    		   if(g1==0)
	    			   list.add("m");
	    		   else
	    			   list.add("f");
	    		   System.out.println(g1 +"is added to the list");
	    		   
	    		   int g2 = random.nextInt(2);
	    		   if(g2==0)
	    			   list.add("m");
	    		   else
	    			   list.add("f");
	    		   System.out.println(g2 +"is added to the list");
	    		   
	    		   
	    		  // System.out.println(c +"is added to the list");
	    	   }
                }
	    	}
	    	   
	    	
	    
	
	//@Override
	//Random random=new Random();
	public void run() {
		// TODO Auto-generated method stub
		meet(this);

	}


public static void main(String args[]) {
	
	
	 int n = 5; // Number of threads
     for (int i = 0; i < n; i++) {
         Thread object= new Multithread();
         object.start();
}
}
}
