public class KoalaCounting {

    public static int getAvg( int[] arr ){
        int total = KoalaCounting.getTotal(arr); 
        return total / arr.length; 
    }

    public static int getTotal( int[][] arr2D){
        int total = 0; 

        for( int[] day: arr2D ){
            for( int eachCount: day){
                total += eachCount; 
            }
        }

        return total; 
    }

    public static int getTotal( int[] arr ){
        int total = 0; 

        for( int indiCount: arr){
            total += indiCount; 
        }

        return total; 
    }
    public static void main( String[] args ){
        /* int[] dayOne = {17, 13, 19, 22};
        System.out.println(getTotal(dayOne));
        System.out.println( "Expected count: 71"); 
        System.out.println(getAvg(dayOne));
        System.out.println( "Expected average: 17"); */

        int[][] koalaSpottings = {{17, 13, 19, 22}, {12, 18, 25, 20}, {15, 18, 21, 24}, {19, 23, 23, 22}, {18, 20, 21, 26}};
        System.out.println(getTotal(koalaSpottings));
        System.out.println("Total expected: 396");
    }
}
