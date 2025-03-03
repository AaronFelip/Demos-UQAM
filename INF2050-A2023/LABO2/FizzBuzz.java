public class FizzBuzz {

    public static void main ( String [] args ) {

        int nombre = 100;

        for ( int i = 1; i <= nombre ; i++ ) {

            if ( i % 3 == 0 && i % 5 == 0 ) {

                System.out.println( "FizzBuzz" );//multiple de 15

            } else if ( i % 3 == 0 ) {

                System.out.println( "Fizz" );// multiple de 3

            } else if ( i % 5 == 0 ) {

                System.out.println( "Buzz" );// multiple de 5

            } else {

                System.out.println( i );

            }

        }

    }

}