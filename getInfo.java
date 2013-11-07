import java.util.Random;

import javax.swing.JOptionPane;
//This class will be used to obtain information from the user related to processes
public class getInfo 
{
	public static double[] burst (int irq)
	{
		int choice=0;
		double exec[]=new double [irq];
	/*ask user if they'd like to enter their burst times or have them generated automagically
	ensure that all entries are doubles*/
		try
	    {
		    String sburst = JOptionPane.showInputDialog( "  1)Manually Enter Burst Times\n" +
	    	        "  2) Automatically Generate Burst Times\n");
		    choice=Integer.parseInt(sburst);	
		}
	 
	    catch (NumberFormatException e)
	    {
			JOptionPane.showMessageDialog(null,"Please enter a valid choice" + "\n");
			System.exit(0);
	    }
		
		//For manual entry, we store all times in an array and ensure that the are doubles
		if (choice == 1)
		{
		
			for (int i=1; i<=irq; i++)
			{
				try
				{
					String sExec = JOptionPane.showInputDialog("Please enter the execution time for process" + " " + i);
					exec[i-1] = Double.parseDouble(sExec);
				}
		 
				catch (NumberFormatException e)
				{
				JOptionPane.showMessageDialog(null,"Please enter a valid execution time" + "\n");
				}
			}
		}
		//Random number generator generates burst times if user selects this option
		if (choice == 2)
		{
			Random generator = new Random();
			for (int i=1; i<=irq; i++)
			{ 
				exec[i-1] = generator.nextDouble() * 10.0;
			}	
		}
	
	return exec;
	}
	//Ask for size of queue and check that the user inputs an integer
		public static int getRQ(int mchoice)
		{
			if(mchoice==3)
			{
				System.exit(0);
			}
			int irq=0;
			try
			{
			   String srq = 	JOptionPane.showInputDialog("How many processes are in your ready queue?");
			   irq = Integer.parseInt(srq);	   
			}
			 
				catch (NumberFormatException e)
				{
				JOptionPane.showMessageDialog(null,"Please enter a valid number of processes" + "\n");
				}  
			return irq;		
	
		
		}

}
