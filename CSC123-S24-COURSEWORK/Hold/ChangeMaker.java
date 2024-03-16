
//Name: Pablo Conde 
//Email: pconde1@csudh.edu

public  class ChangeMaker{
      //declare instance fields 
		private int dollars;
		private int cents;
		
		//Constructor 
      public ChangeMaker(int dollars, int cents){
    	  if (dollars < 0 || cents <0) {
    		  System.out.println("Please input a non-negative value.");
    		  this.dollars = 0;
    		  this.cents = 0;
    	  }
    	  else {
    		  this.dollars = dollars;
    		  this.cents = cents;
    	  }
      }

      public int getQuarters(){

          //  return number of quarters
    	  int totalCents = totalCents = (dollars * 100) + cents;
    	  return totalCents / 25;

      }

      public int getDimes(){

          //return the number of dimes
    	  int totalCents = totalCents = (dollars * 100) + cents;
    	  return (totalCents % 25)/10;

      }

      public int getNickles(){

          //return number of nickles
    	  int totalCents = totalCents = (dollars * 100) + cents;
    	  return (totalCents % 25)%10/5;


      }

      public int getPennies(){

          //return number of pennies
    	  int totalCents = totalCents = (dollars * 100) + cents;
    	  return (totalCents % 25)%10%5;


      }
      
}      