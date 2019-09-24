package com.trilogyed;

public class ModulusAnimation
{
    public static void main( String[] args ) throws Exception
    {
        for ( int i=0; i<80; i++ )
        {
            if ( i%22 == 0 )
                System.out.print(" L*******                 \r");
            else if ( i%22 == 1 )
                System.out.print("   Lo*******               \r");
            else if ( i%22 == 2 )
                System.out.print("     Loa*****             \r");
            else if ( i%22 == 3 )
                System.out.print("       Load****           \r");
            else if ( i%22 == 4 )
                System.out.print("         Loadi***         \r");
            else if ( i%22 == 5 )
                System.out.print("           Loadin**       \r");
            else if ( i%22 == 6 )
                System.out.print("             Loading*     \r");
            else if ( i%22 == 7 )
                System.out.print(" L*******                 \r");
            else if ( i%22 == 8 )
                System.out.print("   Lo*******               \r");
            else if ( i%22 == 9 )
                System.out.print("     Loa*****             \r");
            else if ( i%22 == 10 )
                System.out.print("       Load****           \r");
            else if ( i%22 == 11 )
                System.out.print("         Loadi***         \r");
            else if ( i%22 == 12 )
                System.out.print("           Loadin**       \r");
            else if ( i%22 == 13 )
                System.out.print("             Loading*     \r");

            Thread.sleep(300);
        }

    }
}
