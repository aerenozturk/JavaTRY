package KurwaCoTam;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    
      ReentrantLock lock = new ReentrantLock();
    String data;

    public ReentrantLockEx(){

    }
    public String read() throws InterruptedException{
        lock.lock();
        try{
            System.out.println("Read block: ");
            System.out.println(this.data);
            Thread.sleep(2000);
            return data;
        } finally{
            lock.unlock();
        }
    }
    public void write(String txt) throws InterruptedException{
        lock.lock();
        try{
            System.out.println("Write block: "+ txt);
            this.data = txt;
            Thread.sleep(5000);
        } finally{
            lock.unlock();
        }

    }
    public void append(String txt) throws InterruptedException{
        lock.lock();
        try{
            System.out.println("Append block: "+ txt);
            data += txt;
            Thread.sleep(5000);
        } finally{
            lock.unlock();
        }
    }
    public static void main(String[] args){
        ReentrantLockEx ex = new ReentrantLockEx();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    ex.write("Hello");
                } catch(InterruptedException e){}
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    ex.append(" World");
                } catch(InterruptedException e){}
            }
        });
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    ex.read();
                } catch(InterruptedException e){}
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
