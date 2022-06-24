
public class BurritoCalculator {
    public static int getReverseBudget ( int budget ){
      int reverseBudget = 0;
      
      while( budget > 0 ){
        reverseBudget = (reverseBudget * 10) + (budget % 10);
        budget /= 10;  
      }

      return reverseBudget; 
    }

    public static int getTip( int budget ){
      int maxDigit = 0; 

      while ( budget > 0 ){
        maxDigit = maxDigit < budget % 10 ? budget % 10 : maxDigit;
        budget /= 10;  
      }

      /*
      // returns decimal value of expected ascii value.  
      String myNumber = Integer.toString(budget);
      char[] myDigits = myNumber.toCharArray();  
      for( int i = 0; i < myDigits.length; ++i){
        if ( maxDigit == 9){
          break; 
        }
      
        maxDigit = maxDigit < myDigits[i] ? myDigits[i] : maxDigit; 
      } */

  
      return maxDigit *= 900; 
    }

    public static int getNumDivisibleOrders(int lastOrderNumber) {
        int numDivisbleOrders = 0;
        for (int i = 1; i <= lastOrderNumber; i++) {
            if (i % 9 == 0) {
              numDivisbleOrders++;
            }
          }
    
        return numDivisbleOrders;
      }

    public static int getBurritosSold( int lastOrderNumber ){
        int totalBurritosSold = lastOrderNumber + 1; 
        return totalBurritosSold; 
    }

    public static boolean hasLeftOverFunds( int burritoCost ){
        int budget = 100; 
        int numBurritos = 0; 

        while( budget >= burritoCost ){
            numBurritos++; 
            budget -= burritoCost; 
        }

        System.out.println("Remaining budget: " + budget); 

        //boolean temp = (budget > 0) ? true : false; 
        //return temp;
        return budget > 0;  
    }

    public static int getBurritoQuantity(int burritoCost) {
        int budget = 4267;
 
        int numBurritos = 0;
        while (budget >= burritoCost) {
          numBurritos++;
          budget -= burritoCost;
        }
 
        return numBurritos;
    }
 
     public static void main(String []args){
        System.out.println(getBurritoQuantity(7));
        System.out.println(hasLeftOverFunds(7));
        System.out.println(hasLeftOverFunds(10));
        System.out.println(getBurritosSold(548));
        System.out.println(getNumDivisibleOrders(18));
        System.out.println(getTip(123));
        System.out.println(getReverseBudget(123456));
      }
}
