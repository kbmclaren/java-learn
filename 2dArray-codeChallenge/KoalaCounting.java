/*
 * This class allows the user to apply basic math/statistical methods
 * to field data collected about Koalas. 
 * 
 * This class accepts 1-D and 2-Dimensional int arrays. 
 * 1-D arrays are expected to hold a single day of observational data.
 * 2-D arrays are expected to hold as many days of data as there are sub arrays.
 * 
 * File: KoalaCounting.java
 * Author: Caleb M. McLaren
 * Date: July, 2022
 */

public class KoalaCounting {

    //*******************************************
    // Constants
    //*******************************************

        // None
    
    //*******************************************
    // Fields
    //*******************************************

        //None

    //*******************************************
    // Constructors
    //*******************************************

        //None

    //*******************************************
    // Private Methods
    //*******************************************

        //None

    //*******************************************
    // Public Methods
    //*******************************************

    /**
     * Returns the intuitive index of the column with the largest sum of Koala observations.
     * @param arr2D 2-Dimensional array of Koala Observations, 
     * each column represents a unique observer,
     * each row reps. a unique day.
     * @return the array index + 1 (column/observer) with the largest sum of Koala observations.
     */
    public static int largestColumn( int[][] arr2D ){
        int largestColumn = 0; 
        int largestSum = 0; 

        //iterate through columns of arr2D
        //reasign largestColumn if columnVal > largestSum
        for( int k = 0; k < arr2D[k].length; ++k){

            int columnVal = 0;
            for( int i = 0; i < arr2D.length; ++i){

                columnVal += arr2D[i][k];
            }   

            if( columnVal > largestSum ){
                largestSum = columnVal;
                largestColumn = k; 
            }
        }
        //Returns the intuitive index of the column instead of array index.
        return largestColumn + 1; 
    }

    /**
     * Returns a count of the Koala sightings that are strictly greater than the targetNum.
     * @param arr2D the 2-Dimensional array where each sub array is a day of observations, 
     * and each entry in a sub-array is the number of Koalas observed by a citizen scientist.
     * @param targetNum the koala observation value we are worried about.
     * @return the count of Koala observations in arr2D greater than targetNum.
     */
    public static int findValuesGreaterThan( int[][] arr2D, int targetNum ){
        int count = 0; 
        for( int[] day: arr2D ){
            for( int eachCount: day){
                if ( eachCount > targetNum){
                    count += 1; 
                }
            }
        }
        return count; 
    }

    /**
     * Returns the average Koala sighting value.
     * @param arr 1-Dimensional array where each entry is a single observer's Koala sighting count.
     * @return The total koala count divided by the number of observers=(arr.length).
     */
    public static int getAvg( int[] arr ){
        int total = KoalaCounting.getTotal(arr); 
        return total / arr.length; 
    }

    /**
     * Takes in 2-Dimensional integer array of Koala sightings.
     * Returns total count.
     * @param arr2D 2-D array holding Koala sighting data for multiple days.
     * @return The result of multiple days of koala sightings added to total. 
     */
    public static int getTotal( int[][] arr2D){
        int total = 0; 

        for( int[] day: arr2D ){
            for( int eachCount: day){
                total += eachCount; 
            }
        }

        return total; 
    }

    /**
     * Takes in 1-Dimensional integer array of Koala sightings
     * Returns total count. 
     * @param arr 1-D array holding Koala sighting data for a single day.
     * @return The result of the individual counts in arr added to total.
     */
    public static int getTotal( int[] arr ){
        int total = 0; 

        for( int indiCount: arr){
            total += indiCount; 
        }

        return total; 
    }

    //*******************************************
    // Main
    //*******************************************
    public static void main( String[] args ){
        /* int[] dayOne = {17, 13, 19, 22};
        System.out.println(getTotal(dayOne));
        System.out.println( "Expected count: 71"); 
        System.out.println(getAvg(dayOne));
        System.out.println( "Expected average: 17"); */

        int[][] koalaSpottings = {{17, 13, 19, 22}, {12, 18, 25, 20}, {15, 18, 21, 24}, {19, 23, 23, 22}, {18, 20, 21, 26}};
        /* System.out.println(getTotal(koalaSpottings));
        System.out.println("Total expected: 396"); */
        /* System.out.println(findValuesGreaterThan(koalaSpottings, 20));
        System.out.println("Total expected: 9"); */
        System.out.println(largestColumn(koalaSpottings));
        System.out.println("Intuitve Column expected: 4");
    }
}
