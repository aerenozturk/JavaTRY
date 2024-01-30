package KurwaCoTam;

public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment(){
        System.out.println("Incrementing "+ Integer.toString(c)+ " to : " + Integer.toString(c+1));
        c++;
    }

    public synchronized void decrement(){
        System.out.println("Decrementing "+ Integer.toString(c)+ " to : " + Integer.toString(c-1));
        c--;
    }
    public synchronized int value(){
        return c;
    }
    public static void main(String[] args){
        SynchronizedCounter counter = new SynchronizedCounter();

        Request request1 = new Request(counter, 9000, true);
        Request request2 = new Request(counter, 4000, false);
        Thread thread1 = new Thread(request1);
        Thread thread2 = new Thread(request2);
        thread1.start();
        thread2.start();
       // request1.run();
       // request2.run();
    }

static class Request implements Runnable {
    SynchronizedCounter counter;
    int sleepTime;
    boolean opType;


    public Request(SynchronizedCounter counter, int sleepTime, boolean opType){
        this.counter = counter;
        this.sleepTime = sleepTime;
        this.opType = opType;

    } 
    @Override
    public void run(){
        System.out.println("Thread is going to run for: " + Integer.toString(sleepTime) + " seconds");
        if(opType){
            counter.increment();
        } else{
            counter.decrement();
        }
        try{
            Thread.sleep(sleepTime);
        } catch(InterruptedException e){}
    }
}    
}