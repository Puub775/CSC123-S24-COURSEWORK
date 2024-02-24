//Name: Pablo Conde 
//Email: pconde1@csudh.edu

public  class CoinCounter{
 //declare instance fields
		private int quarters;
		private int dimes;
		private int nickels;
		private int pennies;
     

      //Constructor ]

      public CoinCounter(int quarters, int dimes, int nickles, int pennies){

         //implement your code here
    	this.quarters = quarters;
  		this.dimes = dimes;
  		this.nickels = nickles;
  		this.pennies = pennies;

      }

      public int getDollarAmount(){

          //  return dollar amount:
    	  int totalCents = getTotalCents();
    	  
    	  return totalCents / 100;
    	  

      }

      public int getCentsAmount(){

          //return cent amount;
    	  return getTotalCents() % 100;

      }
      //get total cents
      private int getTotalCents() {

    	  int totalCents = 0;
    	  
    	  totalCents += quarters * 25;
    	  totalCents += dimes * 10;
    	  totalCents += nickels * 5;
    	  totalCents += pennies * 1;
    	  
    	  return totalCents;
      
      }
      
}      