import java.io.*;
//Resolve DeadLock in java or use join method.
public class GFG {  
  public static void main(String[] args) {  
    final String resource1 = "ratan jaiswal";  
    final String resource2 = "vimal jaiswal";  
    // t1 tries to lock resource1 then resource2  
    Thread t1 = new Thread() {  
      public void run() 
      {  
          synchronized (resource1) 
          {  
                 System.out.println("Thread 1: locked resource 1");  
                 try { Thread.sleep(100);} 
                 catch (Exception e) {}  
                synchronized (resource2) 
                   {  
                    System.out.println("Thread 1: locked resource 2");  
                   }  
                   System.out.println("Thread 1: resource 2 lock released");  
         }  System.out.println("Thread 1: resource 1 lock released");  
      }  
    };  
  
    // t2 tries to lock resource2 then resource1  
    Thread t2 = new Thread()
    {  
      public void run() 
      {  
        synchronized (resource2) 
        {  
          System.out.println("Thread 2: locked resource 2");  
  
          try { Thread.sleep(100);} catch (Exception e) {}  
  
              synchronized (resource1) 
              {  
                System.out.println("Thread 2: locked resource 1");  
              }  System.out.println("Thread 2: resource 1 lock released");  
        } System.out.println("Thread 2: resource 2 lock released");   
      }  
    };  
  
      
    t1.start();  
   // try{t1.join();}
    //catch(InterruptedException ie){}
    t2.start();
//    try{t2.join();}
 //   catch(InterruptedException ie){}
  }  
}  
