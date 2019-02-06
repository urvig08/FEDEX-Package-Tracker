package Assign4;


import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.rmi.dgc.Lease;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.FormatFlagsConversionMismatchException;

public class FedExGUI extends JFrame implements ActionListener {

	public JButton track_button,start_buttons[],create_button;
	public JLabel labels[];
	public JTextField tfields[];
	public JLabel displaytext[];
	public Details details;
	java.util.Date shipping_date;
	
	String flag ="Start";
	String path_name=null;
	Activity activity = new Activity();
	
	String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday",
	        "Thursday", "Friday", "Saturday"};
	
	public FedExGUI() {
		   setSize(1000,500);
	        setLocation(200,200);
	        ContainerSetup(flag);
	        show();
		
		
		// TODO Auto-generated constructor stub
	}
	
	 private void ContainerSetup(String step)
		{
		 if(step.matches("Start")){

		        Container c = getContentPane();

		        start_buttons = new JButton[2];
		        JPanel cpanel = new JPanel();
		        cpanel.setBorder(BorderFactory.createLoweredBevelBorder());
		        cpanel.setLayout(new GridLayout(2,2));
		        
		        start_buttons[0] = new JButton("Create a new package Request");
		        start_buttons[0].addActionListener(this);

		        start_buttons[1] = new JButton("Check Status");
		        start_buttons[1].addActionListener(this);
		        cpanel.add(start_buttons[0]);
		        cpanel.add(start_buttons[1]);
		        
		        c.add(cpanel,BorderLayout.WEST);
		        
		 }
		 
	 else if(step.matches("Status")){
	        Container c = getContentPane();

	        labels = new JLabel[10];
	        labels[0] = new JLabel("Enter tracking number");

	        tfields = new JTextField[10];
	        tfields[0] = new JTextField(30);
	 
	        track_button = new JButton("Submit");
	        track_button.addActionListener(this);
	        
	        
	        //Center Layout
	        JPanel cpanel = new JPanel();
	        cpanel.setBorder(BorderFactory.createLoweredBevelBorder());
	        cpanel.setLayout(new GridLayout(3,2));
	        cpanel.add(labels[0]);
	        cpanel.add(tfields[0]);
	        cpanel.add(track_button);
	        
	       
	        c.add(cpanel,BorderLayout.CENTER);
	        show();
	       }
		 
	 else if(step.matches("Create")){
	        Container c = getContentPane();

	        labels = new JLabel[11];
	        labels[0] = new JLabel("Enter tracking number");
	        labels[1] = new JLabel("Enter weight");
	        labels[2] = new JLabel("Enter signature services");
	        labels[3] = new JLabel("Enter packaging");
	        labels[4] = new JLabel("Enter services");
	        labels[5] = new JLabel("Enter dimensions");
	        labels[6] = new JLabel("Enter special handling section");
	        labels[7] = new JLabel("Enter source location");
	        labels[8] = new JLabel("Enter destination");
	        labels[9] = new JLabel("Enter shipping date");
	        labels[10] = new JLabel("Enter estimated date");
	        

	        tfields = new JTextField[11];
	        
	        JPanel cpanel = new JPanel();
	        cpanel.setBorder(BorderFactory.createLoweredBevelBorder());
	        cpanel.setLayout(new GridLayout(23,2));
	        
	        for(int i =0; i< labels.length;i++)
	        	tfields[i] = new JTextField(20);
	 
	        for(int i =0; i<labels.length;i++){
	        	cpanel.add(labels[i]);
		        cpanel.add(tfields[i]);
		        	
	        }
	        
	        create_button = new JButton("Submit");
	        create_button.addActionListener(this);
	        cpanel.add(create_button);
		        
	        
	        //Center Layout
	        
	       
	        c.add(cpanel,BorderLayout.CENTER);
	        show();
	       }

		 
		 
		 else if(step.matches("Track")){
			 Container c = getContentPane();
			 JPanel cpanel = new JPanel();
			    cpanel.setBorder(BorderFactory.createLoweredBevelBorder());
			    cpanel.setLayout(new GridLayout(14,2));
	
		
				
				
				
			    
			    displaytext = new JLabel[30];
			    
			    String[]  info = {"Tracking Number: " + details.getTracking_number(),
			    		"Weight: " +details.getWeight() ,"Signature Services: " + details.getSignature_services(), 
			    		"Packaging: " + details.getPackaging(),"Services: "+ details.getServices(),
			    		"Dimensions: "+details.getDimensions(),"Special Handling Section: "+details.getSpecial_handling_section(),
			    		"Source City: " + details.getSource_city(),
			    		"Destination: "+details.getDestination()
			    		,"Shipping Date: "+details.getShipping_date(),"Estimated Date: "+details.getEstimated_date()};
			    
			    for(int i =0; i<info.length;i++){
			    	displaytext[i] = new JLabel(info[i]);
			    	//displaytext[i].setEnabled(false);
			    	cpanel.add(displaytext[i]);
			    	System.out.println(info.length + "\t" + info[i]);
			    }
			    
			
				 c.add(cpanel,BorderLayout.EAST);
				 //setSize(1200,720);
				 
				 
				 
				 
				 JPanel spanel = new JPanel();
				    spanel.setBorder(BorderFactory.createLoweredBevelBorder());
				    
				   
				    TestDatabase database = new TestDatabase();
				    ArrayList<Activity> activitylist = database.getactivities(details.getTracking_number());
				    JLabel [] activitytext = new JLabel[30];
				    
				    spanel.setLayout(new GridLayout(activitylist.size(),1));
				    for(int i =0 ; i< activitylist.size();i++){
				    	activitytext[i] = new JLabel(activitylist.get(i).toString());
				    	spanel.add(activitytext[i]);
				    }
				    
				    c.add(spanel,BorderLayout.SOUTH);
				    setSize(1400,800);
				    show();
				     
				    
				    
		
		 }
		}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Object source = arg0.getSource();
		if(flag.matches("Start")){
		
		if (source == start_buttons[0]) {
			
			flag = "Create";
			ContainerSetup(flag);
			
	}else if (source == start_buttons[1]) {
		flag="Status";
		ContainerSetup(flag);
		
		}
		
		}
		else if(flag.matches("Status")){
			if(source == track_button ){
				TestDatabase database = new TestDatabase();
				details = database.getorderdetails(tfields[0].getText());
				flag="Track";
				ContainerSetup("Track");
			}
		}
			else if(source == create_button && flag.matches("Create")){
				details = new Details();
				details.setTracking_number(tfields[0].getText());
				details.setWeight(tfields[1].getText());
				details.setSignature_services(tfields[2].getText());
				details.setPackaging(tfields[3].getText());
				details.setServices(tfields[4].getText());
				details.setDimensions(tfields[5].getText());
				details.setSpecial_handling_section(tfields[6].getText());
				details.setSource_city(tfields[7].getText());
				details.setDestination(tfields[8].getText());
				details.setShipping_date(tfields[9].getText());
				details.setEstimated_date(tfields[10].getText());
				
				TestDatabase database = new TestDatabase();
				int rs = database.storedetails(details);
			
				//Dijkstars' execution
				
				Graph graph = new Graph();
				graph.init();
				ArrayList<String> path = graph.startfinding(details.getSource_city(), details.getDestination());
				
				// Converting string to date
				try{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				shipping_date= formatter.parse(details.getShipping_date());		
				}catch(Exception ex){
					
				}
				for(int i=0;i<path.size();i++){
					System.out.println("PAth \t"+ path.get(i));
					Calendar c = Calendar.getInstance();
				    c.setTime(shipping_date);
				    c.add(Calendar.HOUR, 1);
				    shipping_date = c.getTime();

				    if(i == 0){
				    	 activity.setTracking_number(details.getTracking_number());
						    activity.setDelivery_status("Shipped");
						    activity.setDate(String.valueOf(shipping_date));
						    activity.setDay(days[shipping_date.getDay()]);
						    activity.setLocation(path.get(i));
						    activity.setMessage("Shipped from " + path.get(i));
						    database.store_activity(activity);
				    }else if(i==path.size()-1){
				    	 activity.setTracking_number(details.getTracking_number());
						    activity.setDelivery_status("Deleivered");
						    activity.setDate(String.valueOf(shipping_date));
						    activity.setDay(days[shipping_date.getDay()]);
						    activity.setLocation(path.get(i));
						    activity.setMessage("Out for Delivery.");
						    database.store_activity(activity);
				    	
				    }
				    else{
				    activity.setTracking_number(details.getTracking_number());
				    activity.setDelivery_status("In Transit");
				    activity.setDate(String.valueOf(shipping_date));
				    activity.setDay(days[shipping_date.getDay()]);
				    activity.setLocation(path.get(i));
				    activity.setMessage("On route to " + path.get(i+1));
				
				    MultithreadingDemo object = new MultithreadingDemo(); 
				
		            object.start();
		        	try {
						object.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    }
					
					
		           
				}
				
				
				// Java code for thread creation by extending 
				// the Thread class 
		
			/*	MultithreadingDemo object = new MultithreadingDemo(); 
	            object.start(); 
	           */ 
	      	
				
				
				
				
/*				flag="Track";
				ContainerSetup("Track");
*/			}
			
				}
		
	class MultithreadingDemo extends Thread 
	{ 
	    public void run() 
	    { 
	        try
	        { 
	        	
	        	TestDatabase database = new TestDatabase();
			    int rs = database.store_activity(activity);
			    System.out.println(shipping_date);
			    
	        } 
	        catch (Exception e) 
	        { 
	            // Throwing an exception 
	            System.out.println ("Exception is caught"); 
	        } 
	    } 
	} 
	
	
	public static void main (String args[] )
	{
        FedExGUI app = new FedExGUI();

        app.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) { System.exit(0); } 
		});

    }

}
