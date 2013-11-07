/* CPU Scheduler using Shortest Job First and First Come First Serve
 * Matthew Wimpelberg 
 * Christopher Scholl
 * In our program, we make the assumption that all processes arrive at the same time
 * We chose to use three classes.  One will print the menu and call classes, one will get all 
 * relevant info from the user, and finally calculate will do the heavy lifting.  Since both
 * algorithms do similar calculations, calculate holds methods for both.
 * 
 *  This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class MainClass
{
	public static void main(String[] args) 
	{
		int choice;
		int irq;
	    DecimalFormat df = new DecimalFormat("#.##");
		//Standard menu choices that will show after each complete action while exit is not selected
		do
		{		
			choice=showMenu();	
			switch (choice)
			{
			//Each case asks for number of processes and feeds the array and number into methods
			case 1: 
			irq=getInfo.getRQ(choice);	
			JOptionPane.showMessageDialog(null,"You entered "+ irq + " processes.");
			double [] fcfsExec=getInfo.burst(irq);
		    JOptionPane.showMessageDialog(null,"The average turnaround time is" + " " +df.format(calculate.avgTurnaroundTime(fcfsExec, irq)));
		    JOptionPane.showMessageDialog(null,"The average wait time is" + " " +df.format(calculate.avgWaitTime(fcfsExec, irq)));
			break;
			case 2:
			irq=getInfo.getRQ(choice);	
			JOptionPane.showMessageDialog(null,"You entered "+ irq + " processes.");
			double [] sjfexec=getInfo.burst(irq);
			//The key difference between SJF and FCFS is here where the array is sorted
		    double[] sortExec=calculate.sortBurst(sjfexec);
		    JOptionPane.showMessageDialog(null,"The average turnaround time is" + " " +df.format(calculate.avgTurnaroundTime(sortExec, irq)));
		    JOptionPane.showMessageDialog(null,"The average wait time is" + " " +df.format(calculate.avgWaitTime(sortExec, irq)));
			break;
			case 3:
			System.exit(0);
			break;
			}
		}while (choice!=3);
	}
	
	//ask user for choice of algorithm and ensure that the user enters an integer

	public static int showMenu()
	{
		int mchoice=0;
	    try
	    {
		    String s = JOptionPane.showInputDialog(
			        "Select an algorithm: \n" +
			    	        "  1) First Come First Serve\n" +
			    	        "  2) SJF\n" +
			    	    	"  3) EXIT\n");
		    mchoice = Integer.parseInt(s);
		    if(mchoice>3)
		    {
		    	JOptionPane.showMessageDialog(null,"Please enter a valid choice");
		    }	   
		}
	    
	 
		catch (NumberFormatException e)
	    {
	    	JOptionPane.showMessageDialog(null,"Please enter a valid choice");
	    }
	    return mchoice;
	}
}
