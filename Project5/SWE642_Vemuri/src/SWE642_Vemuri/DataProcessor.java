//Krishna Sindhuri Vemuri- G01024066
//Methods for Mean and Standard Deviation calculation
package SWE642_Vemuri; 


public class DataProcessor{
	
	  public double Standard_Deviation_Method(String data, float Mean){
	    	String data1[] = data.split(",");
	    	double sum=0;
	    	double Standard_Deviation = 0;
			for(int i=0; i< data1.length; i++){
	    		sum = Math.pow((Integer.parseInt(data1[i]) - Mean), 2); 
	    	}
			Standard_Deviation =  Math.sqrt(sum/(data1.length));
	    	return Standard_Deviation;
	    }

     public float Mean_Method(String data){
    	String data1[] = data.split(",");
    	float Mean = 0;
		for(int i=0; i< data1.length; i++)
    		Mean = Mean+ Integer.parseInt(data1[i]);
    	 Mean = Mean/ data1.length;
    	return Mean;
    }
    
  
}