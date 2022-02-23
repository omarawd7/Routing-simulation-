package OS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javax.swing.SwingWorker;

public class Device extends Thread {
	 public  static ArrayList<String> Toutput = new ArrayList<String>(); 
	 
    Router router;
    String Name;
    String Type;
    int NumOfDevice;


    public static void addout (String x) {
    	Toutput.add(x);    	
    }

    public Device(String name,Router router) throws IOException {
        super(name);
        this.router=router;

    }

    Runnable doWork= new Runnable() {
    @Override
    public void run() {

    	
            router.obj.release(Device.this);
            try {
                NumOfDevice=router.occupy(Device.this);
                
            } catch (Exception e) {
                System.out.println("Error!");
            }
        try {
        	  router.Login(Device.this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            try {
                router.performOnlineAcv(Device.this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        router.logOut(Device.this);
        router.obj.take();
    }
};
    }
