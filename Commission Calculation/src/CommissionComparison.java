/*
 * This class is responsible for stroring the names and the sales of the
 * salesmen in arrays, comparing the amount each salesman made and displaying 
 * the salesman that made more along with the difference between the two.
 * @author Joel Wood
 */

import java.text.DecimalFormat;//needed for USDollar format output

public class CommissionComparison {
    
    // Set correct decimal format for USD
    DecimalFormat USDFormat = new DecimalFormat("$#,##0.00");
    
    //creates an array for storing the names of both salesmen
    String[] nameArray = new String[2];
    //creates an array for storing the sales amount of both salesmen
    double[] salesArray = new double[2];
    
    //variable used to store the difference between the sales of the
    //two salesmen
    double difference = 0;
    
    //method to store the name of the first 
    //salesman at index 0 in the name array 
    public void setName1( String name1){
        nameArray[0] = name1;//store the name of the first salesman
    }//end method setName1
    
    //method to store the name of the first 
    //salesman at index 1 in the name array 
    public void setName2( String name2){
        nameArray[1] = name2;//store the name of the second salesman
    }//end method setName2
    
    //method to store the sales of the first 
    //salesman at index 0 in the sales array 
    public void setSales1( double sales){
        salesArray[0] = sales;//store the sales of the first salesman
    }//end method setSales1
    
    //method to store the sales of the first 
    //salesman at index 1 in the sales array 
    public void setSales2( double sales){
        salesArray[1] = sales;//store the sales of the second salesman
    }//end method setSales2
    
    //Displays the results from comparing the sales between the 
    //two salesmen
    public void displayMessage(){
        if ( salesArray[0] > salesArray[1]){
            difference = salesArray[0] - salesArray[1];
            System.out.println("\n" + nameArray[1] + " needs to make an "
                    + "additional" + USDFormat.format(difference) 
                    + " to match the sales of " + nameArray[0] + ".");
        }else if (salesArray[0] < salesArray[1]){
            difference = salesArray[1] - salesArray[0];
           System.out.println("\n" + nameArray[0] + " needs to make an "
                   + "additional" + USDFormat.format(difference) 
                   + " to match the sales of " + nameArray[1] + ".");
        }else if(salesArray[0] == salesArray[1]){
           System.out.println("\nBoth salesmen earned the same amount "
                   + "in sales.");
        }
    }
}
