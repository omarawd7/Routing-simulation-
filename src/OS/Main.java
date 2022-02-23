package OS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

	
	
	
    public static int Num;
    public static void main(String[] args) throws IOException, InterruptedException {
    	Myframe fr= new Myframe();
    	
    	
        Scanner in=new Scanner(System.in);

        System.out.println("What is the number of WI-FI Connections?");
        int numofconn=in.nextInt();
        Router router=new Router(numofconn);

        System.out.println("What is the number of devices Clients want to connect?");
        int numdev=in.nextInt();
        Num=numdev;
        Device d[] = new Device[numdev];

        String name,type;
        System.out.println("Enter the devices (name,type) ,please");
        for (int i = 0; i <numdev; i++) {
            name = in.next();
            type=in.next();
            d[i] = new Device(name,router);
        }

        Thread t;
        for (int j = 0; j <numdev; j++) {
        	t=new Thread (d[j].doWork);
            Thread.sleep(1000);
           t.start();
        }


    }
}
