public class Conditionals {
    public static void main(String[] args) {
        // doesn't work like expected
        //must use String class .equals() method.
        if( args[0] == "breakfast" ){
            System.out.println("Let's have waffles!");
        }
        else if ( args[0] == "lunch" ){
            System.out.println("Let's have sandwiches!");
        }
        else if ( args[0] == "dinner" ){
            System.out.println("Let's have pizza!");
        }
        else{
            System.out.println("It's not time to eat!");
        }
        /* boolean breakfastTime = false;
        boolean lunchTime = false;
        boolean dinnerTime = true;
        if (breakfastTime) {
          System.out.println("Let's have waffles!");
        } else if (lunchTime) {
           System.out.println("Let's have sandwiches!");
        } else if (dinnerTime) {
           System.out.println("Let's have pizza!");
        } else {
           System.out.println("It's not time to eat!");
        } */
    }
}
