package OS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class Myframe extends JFrame implements ActionListener{
	JPanel in=new JPanel(); 
	JPanel out=new JPanel(); 
	JLabel lable= new JLabel();
	JLabel lable1= new JLabel();
	JLabel lable2= new JLabel();
	JLabel lable3= new JLabel();
	JTextArea tx= new JTextArea();
	JScrollPane sp= new JScrollPane(tx);
	
    public static int Num;
    JButton button = new JButton("Click to Choose");
    JButton button1 = new JButton("Click to Choose");
    JButton button2 = new JButton("Click to Choose name and type");
    int numofconn=0;
    int numdev=0;
    String s;
    String name,type;
   // Device d[] = new Device[numdev];
   // Router router=new Router(numofconn);
	////////////////////

 
    
    
    /////////////////////////
	//lable
	Myframe(){
        Font font = new Font("Transitional serif fonts", Font.BOLD, 20);
        tx.setFont(font);
		sp.setPreferredSize(new Dimension(500,500));
		tx.setForeground(Color.BLUE);       
		lable.setText("What is the number of WI-FI Connections?..");
	    lable.setHorizontalTextPosition(JLabel.CENTER);
     	lable.setVerticalTextPosition(JLabel.TOP);
    	lable.setForeground(Color.white);
 		lable.setVerticalAlignment(JLabel.TOP);
        lable.setHorizontalAlignment(JLabel.LEFT);
		
		lable2.setText("What is the number of devices Clients want to connect?");
		lable2.setHorizontalTextPosition(JLabel.CENTER);
		lable2.setVerticalTextPosition(JLabel.TOP);
		lable2.setForeground(Color.white);
		lable2.setVerticalAlignment(JLabel.TOP);
		
		
		lable3.setText("Enter the devices (name,type) ,please");
		lable3.setHorizontalTextPosition(JLabel.CENTER);
		lable3.setVerticalTextPosition(JLabel.TOP);
		lable3.setForeground(Color.white);
		lable3.setVerticalAlignment(JLabel.TOP);


		

	//	lable4.setHorizontalTextPosition(JLabel.CENTER);
	//	lable4.setVerticalTextPosition(JLabel.TOP);
		tx.setForeground(Color.black);
	//	lable4.setVerticalAlignment(JLabel.TOP);
		
		
		lable1.setText("OUTPUT");
		lable1.setHorizontalTextPosition(JLabel.CENTER);
		lable1.setVerticalTextPosition(JLabel.TOP);
		lable1.setForeground(Color.white);
		lable1.setVerticalAlignment(JLabel.TOP);
/////////////////
		this.setLayout(null);
		this.setTitle("OS Project ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true );
		this.setSize(500,750);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(123,50,250));
		this.add(in);
		this.add(out);
		//////////////////////

		//panel
		in.setBackground(new Color(123,50,250));
		in.add(lable);
		in.add(button);
		in.add(lable2);
		in.add(button1);
		in.add(lable3);
		in.add(button2);
		in.setBounds(0,0,500,250);
	
		out.setBackground(new Color(123,50,250));
		out.add(lable1);		
		out.add(sp);
		out.setBounds(0,250,500,500);
		//button
		button.addActionListener(this);
		button.setBackground(new Color(123,50,250));
		button.setHorizontalTextPosition(JLabel.CENTER);
		button.setVerticalTextPosition(JLabel.TOP);
		button.setForeground(Color.white);
		button.setVerticalAlignment(JLabel.TOP);
		
		
		button1.addActionListener(this);
		button1.setBackground(new Color(123,50,250));
		button1.setHorizontalTextPosition(JLabel.CENTER);
		button1.setVerticalTextPosition(JLabel.TOP);
		button1.setForeground(Color.white);
		button1.setVerticalAlignment(JLabel.TOP);
		
		
		button2.addActionListener(this);
		button2.setBackground(new Color(123,50,250));
		button2.setHorizontalTextPosition(JLabel.CENTER);
		button2.setVerticalTextPosition(JLabel.TOP);
		button2.setForeground(Color.white);
		button2.setVerticalAlignment(JLabel.TOP);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			s=JOptionPane.showInputDialog(null,"Enter the number of WI-FI Connections");
			 numofconn=Integer.parseInt(s);  
			
	        Router router=new Router(numofconn);
			
		}
		else if(e.getSource()==button1) {
			s=JOptionPane.showInputDialog(null,"Enter the number of devices Clients want to connect");
			 numdev= Integer.parseInt(s);  

	        Num=numdev;
	        Device d[] = new Device[numdev];
			
		}
		
		
		else if(e.getSource()==button2) {				
			
		    Device d[] = new Device[numdev];
		    Router router=new Router(numofconn);
		    Thread t;
			 for (int i = 0; i <numdev; i++) {
				 
					s=JOptionPane.showInputDialog(null,"Enter the devices (name type) ,separet by space");
					  String[] arr = s.split(" ");					  
					  name=arr[0];
					  type=arr[1];
					  String s=String.valueOf(numdev);  
			
					  try {
						d[i] = new Device( name, router);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			 }
			 
		        for (int j = 0; j <numdev; j++) {
		            try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
				
					}
		            t=new Thread (d[j].doWork);
		            t.start();
		          

		        	//lable1.setText(s);

		     
		        }
		        
		        //////////////////
		        try {					
		        	PrintStream myc =new PrintStream(new File("C:\\Users\\LAPTOP\\eclipse-workspace\\OSssss\\java.txt" ));
		        	System.setOut(myc);
		        	
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        
		       SwingUtilities.invokeLater (new Runnable() {
					@Override
					public void run() {
				          for (int k = 0; k <Device.Toutput.size(); k++) {
					            try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
							
								}
				            	 tx.append( Device.Toutput.get(k)+"\n");

				            	
				            	 
				            }			
					 	
					}

	            });
		        
		       
		        try {					
		        	PrintStream myc =new PrintStream(new File("C:\\Users\\LAPTOP\\eclipse-workspace\\OSssss\\java.txt" ));
		        	System.setOut(myc);
		        	  for (int k = 0; k <Device.Toutput.size(); k++) {
		        		  myc.print(Device.Toutput.get(k)+"\n");
		        	  }
		        	
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        
		        
		        //////////////

			
		}
	
		
	}
	
	
	
}
