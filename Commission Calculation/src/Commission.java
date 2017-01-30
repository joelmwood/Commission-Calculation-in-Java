/**
 *The purpose of this program is to calculate the amount of commission earned 
 * by a display the results to the screen. The program will also calculate 
 * potential compensation of sales up to 150% of what the salesman actually
 * earned. This class is the main class of the program and is responsible for
 * calling the methods in the other class.
 * @author Joel Wood
 */
import java.text.DecimalFormat;//needed for USDollar format output
import java.util.Scanner;//program uses Scanner to get input from the user

public class Commission {
    
     //main method begins program execution
    public static void main(String[] args) {
        // Set correct decimal format for USD
        DecimalFormat USDFormat = new DecimalFormat("$#,##0.00");

        //creates a scanner to obtain input from the user
        Scanner input = new Scanner( System.in );
        
         //create two Calculations objects and assign them to myCalculations1
        //and myCalculation2
        Calculations myCalculations1 = new Calculations();
        Calculations myCalculations2 = new Calculations();
        
        //create a CommissionComparison object and assign it to 
        //myCommissionComparison1
        CommissionComparison myCommissionComparison = new CommissionComparison();
        
        //Prompt for and read the first salesman's name
        System.out.println( "Please enter the first name "
                + "of the first salesman: " );
        String name1 = input.next();//read a line of text
        myCommissionComparison.setName1 ( name1 );//set the sales
        System.out.println();//outputs a blank line
        
        //display  value of salary
        System.out.println( "The default salary is: " + 
                USDFormat.format(myCalculations1.getSalary() ) + "\n");

        //prompt for and read sales amount for the first salesman
        System.out.println( "Please enter the amount of sales for "
                + "the first salesman: \n" );
        double sales = input.nextDouble();//read a line of text
        myCalculations1.setSales ( sales );//set the sales
        myCommissionComparison.setSales1 ( sales );//set the sales
        System.out.println();//outputs a blank line
        
        //Calculate the total commission in the setCommission method
        myCalculations1.setCommission();
        
        //display all the calculations for earned and potential compensation
        myCalculations1.displayMessage();  
        
        //Prompt for and read the first salesman's name
        System.out.println( "Please enter the first name of "
                + "the second salesman:" );
        String name2 = input.next();//read a line of text
        myCommissionComparison.setName2 ( name2 );//set the sales
        System.out.println();//outputs a blank line
        
        //prompt for and read sales amount for the second salesman
        System.out.println( "\nPlease enter the amount of sales for\n"
                + "the second salesman: " );
        sales = input.nextDouble();//read a line of text
        myCalculations2.setSales ( sales );//set the sales
        myCommissionComparison.setSales2 ( sales );//set the sales
        System.out.println();//outputs a blank line
        
        //Calculate the total commission in the setCommission method
        myCalculations2.setCommission();
        
        //display all the calculations for earned and potential compensation
        myCalculations2.displayMessage();  
        
        //display the results of comparing the two salesmen earnings
        myCommissionComparison.displayMessage();
        
    }//end main
}//end class Commission
