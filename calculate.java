import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/*This class will serve to perform all of our calculations.  Because FCFS and SJF are essentially the same, this one class can 
 * work for both.  The only method that is needed by SJF as compared to FCFS is sortBurst
 */
public class calculate 
{
		/*sortBurst uses a selection sort algorithm to compare each element and ensure that they are ordered least to greatest
		*We will pass in the exec array which holds all burst times to be sorted.
		*It returns an array of sorted burst times that were held in a temp variable
		*/
	     public static double[] sortBurst(double[] exec)
	     {
	     double[]sortExec=new double[exec.length];
	     //This portion loops through the array and stores the values in a temp after comparison
	     for(int i=0; i<exec.length; i++)
	     {
	     	for(int j=i+1; j<exec.length; j++)
	     	{
	     		if(exec[i] > exec[j] )
	     		{
	             double temp = exec[j];
	             exec[j] = exec[i];
	             exec[i] = temp;
	     		}
	     	}
	     }
	 
	     for(int k=0; k<exec.length; k++)
	     {
	         sortExec[k]=exec[k];
	     }
	     //Once the comparisons are complete, the method will print PID times to ensure that they have been sorted
		return sortExec;
	}
	   /* Both methods require average turnaround time which keeps a running total and divides by the num of processes
	    * We pass in the burst times (sorted for SJF, unsorted for FCFS) and amount of processes.
	    * The amount of processes will define the number of times the loop executes
	    */
	   public static double avgTurnaroundTime(double exec[],int irq)
	   {
		     for (int m=0; m<exec.length;m++)
				{
		    	DecimalFormat df = new DecimalFormat("#.##");
				JOptionPane.showMessageDialog(null, "PID " + m + " will have a time of " +df.format(exec[m]));
				}
		   double avgTurnaroundTime=0;
		   double[] sum=new double [irq];
		   double wSum=0;
		   double allProcess=exec.length;
		   double running=0;
		   //A running sum is kept as we increment through the array
		   for(int i=0; i<exec.length; i++)
		   {	
				sum[i]=sum[i]+exec[i];
		   }
		   //These two for loops stop at each element of the array and add all of the previous execution times of processes 
		   //which must be added to their turn around time.  The turn around time reflects the entire time from arrival to completion.
		   for (int j=0;j<irq;j++)
		   {
			running=allProcess-j;
				for(int k=0; k<running; k++)
				{
				wSum=sum[k]+wSum;
				}
		   }
		   //Simple division to find average
		   avgTurnaroundTime=wSum/irq;
		   return avgTurnaroundTime;
	   }
	   //Similar to the average turn around time, this method loops through the array keeping track of wait times (execution times of 
	   //previous processes.
		public static double avgWaitTime(double[] exec, int irq)
		{
			double sum = 0;
			double avgWaitTime = 0;
			double runSum[]=new double [irq];
			double finalSum=0;
			//We store each sum as it runs through wait times in an array
			for (int i=0; i<irq-1 ;i++)
			{
				sum = sum + exec[i];
				runSum[i]=sum;
			}
			//We go through the array and find a final sum to use to calculate average
			for (int j=0; j<runSum.length; j++)
			{
				finalSum=finalSum+runSum[j];
			}
			 //Simple division to find average
			avgWaitTime =finalSum/irq;
			return avgWaitTime;
		}
}

