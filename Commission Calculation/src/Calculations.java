/**
 * The purpose of this program is to calculate the amount of commission earned 
 * by a display the results to the screen. The program will also calculate 
 * potential compensation of sales up to 150% of what the salesman actually
 * earned. This class is a secondary class called by the main class and is 
 * responsible assigning values to all the variables and displaying the 
 * results to the screen.
 * @author Joel Wood
 */

import java.text.DecimalFormat;//needed for USDollar format output

public class Calculations {
    // Set correct decimal format for USD
    DecimalFormat USDFormat = new DecimalFormat("$#,##0.00");

    //sets the salary so it can be used to calculate the total amount earned 
    private final double SALARY_AMOUNT = 50000;
    
    //declare sales target
    private final double salesTarget = 120000;
    
    //declares salesAmount
    private double salesAmount;
    
    //declares commission Amount
    public double commAmount;
    
    //declares total to store the total amount earned (sales + comm)
    private double total;
    
    //declares potentialSales
    private double potentSales;
    
    //declares potential Compensation
    private double potentComp;

    //method to retrieve the salaryAmount
    public double getSalary(){
        return SALARY_AMOUNT;//returns salaryAmount to calling method
    }//end method getSalary
    
    //method to set the salary amount 
    public void setSales( double sales){
        salesAmount = sales;//store the sales amount
    }//end method setSales
    
    //method to retrieve the salaryAmount
    public double getSales(){
        return salesAmount;//returns the sales amount when called
    }//end method getSales
    
     //method to set the commission amount 
    public void setCommission(){
        //If salesAmount is less than sales target, regular commission rates
        //are used. If the sales amount exceeds the sales target, the commission
        //is increased by 1.5
        if ( salesAmount < salesTarget){
            commAmount = salesAmount * 0.05;           
        }
        else if ( salesAmount >= salesTarget){
            commAmount = ((( salesAmount - salesTarget) * 1.5) 
                    + (salesTarget * 0.05));
        }
    }//end method setCommission
    
    //method to retrieve the commission Amount
    public double getCommission(){
        return commAmount;//returns the value stores in commAmount when called
    }//end method getCommission
    
    //method to set and retrieve total amount
    //earned by the salesman
    public double getTotal(){
        //this method calculates the total by adding salaryAmount to commAmount
        //and assigning the answer to total
        total = SALARY_AMOUNT + commAmount;
        return total;//returns the total when this method is called
    }//end method getTotal

    //Displays the salary, sales, commmission, and total to the user
    public void displayMessage(){
        //calls getSalary to get the salary of the salesman and display it
        //to the screen
        System.out.printf("The salary for this salesman is: " + 
                USDFormat.format(getSalary() ));
        
        //calls getSales to get the sales of the salesman and display it
        //to the screen
        System.out.printf("\nThe sales for this salesman is: " + 
                USDFormat.format(getSales() ));
        
        //calls getCommission to get the commission of the salesman and display it
        //to the screen
        System.out.printf("\nThe commission for this salesman is: " + 
                USDFormat.format(getCommission() ));
        
         //calls getTotal to get the total earned by the salesman and display it
        //to the screen
        System.out.printf("\nThe total amount earned by this salesman is: " +
                USDFormat.format(getTotal() ));
        
        //Skips two lines in the display for easier reading
        System.out.println();
        System.out.println();
        
        //The following If statement diplays potential commission based on 
        //5000 increments in potential sales
        if (salesAmount >= (salesTarget * 0.8)){
            //sets potential sales and potential comp equal to salesAmount
            //and commAmount so as to not alter their values
            potentSales = salesAmount;
            potentComp = commAmount;
            
            System.out.format("+---------------+----------------------+%n");
            System.out.printf("|Potential Sales|Potential Compensation|%n");
            System.out.format("+---------------+----------------------+%n");
            while ( potentSales < (salesAmount * 1.5) ){
                if (potentSales < 100000){
                    //System.out.print("Potential Sales: ");
                    System.out.printf("| " + USDFormat.format(potentSales));
                    //System.out.print("Potential Compensation: ");
                    System.out.printf("    |  " + 
                        USDFormat.format(potentComp + SALARY_AMOUNT) 
                        + "      ");
                    System.out.println();
                }else if(potentSales >= 100000){
                    //System.out.print("Potential Sales: ");
                    System.out.printf("| " + USDFormat.format(potentSales));
                    //System.out.print("Potential Compensation: ");
                    System.out.printf("   |  " + 
                            USDFormat.format(potentComp + SALARY_AMOUNT) 
                            + "    ");
                    System.out.println();
                }
                
                //increments potentSales and potentComp
                potentSales = potentSales + 5000;
                //Different calculations are needed depending if the sales
                //are above or below the sales target
                if (potentSales < salesTarget){
                    potentComp = potentSales * .05;
                }else{
                    potentComp = ((potentSales - salesTarget)
                            * 1.5) + (salesTarget * 0.05);
                }//end if-else
            }//end while  
            //Closing line of display table
            System.out.format("+---------------+----------------------+%n");
            System.out.println();//prints a separater line for easy reading
        }//end if
    }//end method disaplyMessage
}//end class Calculations
