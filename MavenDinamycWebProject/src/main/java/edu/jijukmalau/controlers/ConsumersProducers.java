/**
 * Entry point for this project. *
 * @author Spiria
 */package edu.jijukmalau.controlers;

// Java program to implement solution of producer 
// consumer problem. 
import java.util.LinkedList; 
  
public class ConsumersProducers 
{ 
    public static void main(String[] args) 
                        throws InterruptedException 
    { 
        // Object of a class that has both produce() 
        // and consume() methods 
        final PC pc = new PC(); 
  
        // Create producer thread 
        Thread t1 = new Thread(new Runnable() 
        { 
            @Override
            
            /** This is a method that does so
             * much that I must write an epic 
             * novel just to describe how much
             * it truly does. */
            /// This method does something
            public void run() 
            { 
                try
                { 
                    pc.produce(); 
                } 
                catch(InterruptedException e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
        // Create consumer thread 
        Thread t2 = new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                try
                { 
                    pc.consume(); 
                } 
                catch(InterruptedException e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
        // Start both threads 
        t1.start(); 
        t2.start(); 
  
        // t1 finishes before t2 
        t1.join(); 
        t2.join(); 
    } 
  
    /* \brief Transform any car calls we can directly link to "answered" directional landing calls
    *
    * We can only be sure that a car call is the result of an \c ANSWERED directional landing call if there are no other car calls at the floor (ie for any lift for any floor <tt>call[]==TRUE but CarCalls[]==0</tt>).
    * \note This function should only be executed after all destination and directional landing calls have already been transformed
    * \param
    */
    public static class PC 
    { 
        // Create a list shared by producer and consumer 
        // Size of list is 2. 
        LinkedList<Integer> list = new LinkedList<Integer>(); 
        int capacity = 2; 

        public void produce() throws InterruptedException 
        { 
            int value = 0; 
            while (true) 
            { 
                synchronized (this) 
                { 
                    // producer thread waits while list 
                    // is full 
                    while (list.size()==capacity) 
                        wait(); 
  
                    System.out.println("Producer produced-"
                                                  + value); 
  
                    // to insert the jobs in the list 
                    list.add(value++); 
  
                    // notifies the consumer thread that 
                    // now it can start consuming 
                    notify(); 
  
                    // makes the working of program easier 
                    // to  understand 
                    Thread.sleep(1000); 
                } 
            } 
        } 
  
        // Function called by consumer thread 
        public void consume() throws InterruptedException 
        { 
            while (true) 
            { 
                synchronized (this) 
                { 
                    // consumer thread waits while list 
                    // is empty 
                    while (list.size()==0) 
                        wait(); 
  
                    //to retrive the ifrst job in the list 
                    int val = list.removeFirst(); 
  
                    System.out.println("Consumer consumed-"
                                                    + val); 
  
                    // Wake up producer thread 
                    notify(); 
  
                    // and sleep 
                    Thread.sleep(1000); 
                } 
            } 
        } 
    } 
} 