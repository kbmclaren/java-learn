//import java.util.ArrayList;

public class GroceryList {
    
    //This solution is funny compared to the simplicity of the given solution.
    // The given solution iterates the for-loop forward and doesn't need the if-elseif-else structure.
    public static void rotateGroceries( String[] groceryList ){
        //just in case a list of a single item given.
        if ( groceryList.length == 1 ){
            return; 
        }

        //single step rotation of last item to front of String[] and 
        //   all other items one index to right/toward back. 
        //more complex would take in the num of steps to rotate.
        //no built in function to rotate Java Arrays.
        String saveString = null; 
        for( int i = groceryList.length - 1; i >= 0; --i ){
            
            if ( (i != (groceryList.length - 1)) && (i != 0) ){ 
                groceryList[i] = groceryList[ i - 1 ]; 
            }

            else if( i == 0 ){
                groceryList[i] = saveString; 
                return; 
            }

            else {
                //if we reached this code, this is the first for-loop traversal
                saveString = groceryList[i]; 
                groceryList[i] = groceryList[ i - 1 ];
            }

        }

        return; 
        // negative index not native to Java.
        /*  
        for( int i = -1; i < groceryList.length; ++i){
            oneTemp = groceryList[ i + 1 ]; 
            groceryList[ i + 1 ] = groceryList[ i ]; 

        }  */
    }

    public static void reverseGroceries( String[] groceryList ){
        //in place, no new memory. 
        // if size is even, then every element moves, if odd, then middle element does not move.
        String twoTemp = null;
        int tempVal = groceryList.length % 2; 

        switch( tempVal ){
            case 0:
                //size is even, every element moves
                for (int temp1 = 0; temp1 < (groceryList.length/2) ; ++temp1) {
                    int temp2 = groceryList.length - 1 - temp1; 
                    //now swap the elements at position temp1 and temp2.
                    twoTemp = groceryList[temp1]; 
                    groceryList[temp1] = groceryList[temp2]; 
                    groceryList[temp2] = twoTemp; 
                    twoTemp = null; 
                }
                break; 

            case 1:
                //if odd, then middle element does not move
                for (int temp1 = 0; temp1 <= ((groceryList.length/2) - 1) ; ++temp1) {
                    int temp2 = groceryList.length - 1 - temp1; 
                    //now swap the elements at position temp1 and temp2.
                    twoTemp = groceryList[temp1]; 
                    groceryList[temp1] = groceryList[temp2]; 
                    groceryList[temp2] = twoTemp; 
                }
                break; 

            default:
                System.out.println("How did we get here?");
                break; 
        }

        return; 
    }

    //make more efficient: if comparison made only between items that have the same first letter. 
    public static boolean hasDuplicates( String[] groceryList ){
        boolean flag = false; 

        if( groceryList.length == 0 || groceryList.length == 1){
            return flag; 
        }

        for( int i = 0; i < (groceryList.length - 1); ++i ){
            for(int k = i + 1; k < groceryList.length; ++k){
                if( groceryList[k].equalsIgnoreCase( groceryList[i] )  ){
                    flag = true; 
                    return flag; 
                }
            }
            
        }

        return flag; 
    }

    public static boolean isAlphabetized( String[] groceryList ){
        boolean flag = true; //true for ascending alphabetized order.

        if( groceryList.length == 0 || groceryList.length == 1){
            return flag = true; 
        }
        for( int i = 0; i < (groceryList.length - 1); ++i ){
            if( groceryList[i + 1].compareToIgnoreCase( groceryList[i] ) < 0  ){
                flag = false; 
                return flag; 
            }
        }
        return flag; 
    }

    public static boolean hasSpecialItem( double[] groceryPrices ){
        boolean flag = false; 

        for( double price: groceryPrices){
            double dolRem = price % 1.0; //This returns a value like 0.999999999999999 for Java reasons. 
            /* double quarters = dollars % 0.25; 
            double dimes = quarters % 0.10; 
            */
            dolRem *= 100; 
            dolRem = Math.floor(dolRem); 
            if( dolRem == 99 ){
                flag = true;
                return flag; 
            }
        }
        return flag; 
    }

    public static String[] getAllergicItems( String[] groceryList, int allergyInt ){
        for( int i = 0; i < groceryList.length; ++i){
            if( groceryList[i].length() <= allergyInt ){
                //non-allergen found, remove from list so only allegens remain. 
                groceryList[i] = "null"; 
            }
        }
        return groceryList; 
    }

    public static double optimizeGroceryList( double[] groceryPrices, double budget){
        double priceToRemove = 0.0; 
        double originalCost = getTotalCost( groceryPrices ); 

        if( originalCost > budget ){
            //find price to remove 
            double[] tempArray = new double[groceryPrices.length];
            int i = 0; 
            for( double price: groceryPrices ){
                //double leastExpensive = getLeastExpensiveItemCost(groceryPrices); 
                tempArray[i] = originalCost - price; 
                ++i; 
            }
            i = 0; 
            double newTopBill = getMostExpensiveItemCost( tempArray );
            while( newTopBill > budget){
                for( int k = 0; k < tempArray.length; ++k ){
                    tempArray[k] = (tempArray[k] == newTopBill) ? tempArray[k] = 0.0 : tempArray[k];
                }
                newTopBill = getMostExpensiveItemCost(tempArray); 
            }

            return priceToRemove = originalCost - newTopBill; 
        }

        return priceToRemove; 
    }

    public static double getLeastExpensiveItemCost( double[] groceryPrices ){
        double leastExpensive = groceryPrices[0];
        
        for(double price: groceryPrices){
            leastExpensive = leastExpensive > price ? price : leastExpensive; 
        }
        
        return leastExpensive; 
    }

    public static double getMostExpensiveItemCost( double[] groceryPrices ){
        double mostExpensive = groceryPrices[0];
        
        for(double price: groceryPrices){
            mostExpensive = mostExpensive < price ? price : mostExpensive; 
        }
        
        return mostExpensive; 
    }

    public static double getTotalCost( double[] groceryPrices ){
        double totalCost = 0.0; 

        for(double price: groceryPrices){
            totalCost += price;
            //totalCost += Math.abs(price); 
        }

        return totalCost; 
    }

    public static void main( String[] args ){
        //double[] groceryPrices = {10.0, 12.3, 8.45, 2.43};
        //System.out.println(getTotalCost(groceryPrices));
        
        //double[] unlikelyGroceryPrices = {100.23, -100.23, 0.0, -78.54};
        //System.out.println(getTotalCost(unlikelyGroceryPrices));

        /* 
        double budget = 30.00; 
        double[] groceryPrices = {10.0, 12.3, 8.45, 2.34};
        System.out.println(getTotalCost(groceryPrices));
        System.out.println(getMostExpensiveItemCost(groceryPrices));
        System.out.println(getLeastExpensiveItemCost(groceryPrices));
        System.out.println("Remove the item priced " + optimizeGroceryList(groceryPrices, budget) + " in order to come under your budget: $" + budget + ".");
        */

        /* String[] groceryList = {"apple", "milk", "banana", "bananas", "chocolate"};
        groceryList = getAllergicItems(groceryList, 5);
        for( int i = 0; i < groceryList.length; ++i ){
            if ( groceryList[i].equals("null") ){
                continue; 
            }
            System.out.println( groceryList[i] );
        } */

        /* double[] groceryList = {10.0, 89.9, 8.99, 2.34};
        System.out.println(hasSpecialItem(groceryList)); */

        /* String[] groceryList = {"apples", "bananas", "banana", "chocolate"};
        System.out.println(isAlphabetized(groceryList)); */

        /* String[] groceryList = {"apples", "banana", "Apples", "chocolate"};
        System.out.println(hasDuplicates(groceryList)); */

        /* String[] groceryList = {"apples", "banana", "Belgrade", "chocolate", "donuts"};
        reverseGroceries(groceryList);

        for (String item : groceryList) {
            System.out.println(item);
        } */

        String[] groceryList = {"apples", "banana", "Apples", "chocolate"};
        rotateGroceries(groceryList);

        for (String item : groceryList) {
        System.out.println(item);
        }
    }
}
