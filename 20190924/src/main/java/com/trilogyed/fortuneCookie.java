package com.trilogyed;

import java.util.Random;

public class fortuneCookie {
    public static void main(String[] args) {
        int fortuneNumberChoosen = 0;

        String fortune1 = "Fortune cookie says: \"The fortune you seek is in another cookie.\"";
        String lotto1 = "13 - 44 - 19 - 37 - 29 - 17";
        String fortune2 = "Fortune cookie says: \"A closed mouth gathers no feet.\"";
        String lotto2 = "18 - 48 - 18 - 38 - 28 - 18";
        String fortune3 = "Fortune cookie says: \"A conclusion is simply the place where you got tired of thinking.\"";
        String lotto3 = "23 - 24 - 29 - 27 - 29 - 27";
        String fortune4 = "Fortune cookie says: \"A cynic is only a frustrated optimist.\"";
        String lotto4 = "13 - 24 - 39 - 47 - 59 - 67";
        String fortune5 = "Fortune cookie says: \"You will die alone and poorly dressed.\"";
        String lotto5 = " 16 - 45 - 14 - 33 - 22 - 11";
        String fortune6 = "Fortune cookie says: \"A fresh start will put you on your way.\"";
        String lotto6 = "13 - 44 - 15 - 36 - 27 - 18";

        Random randomGenerator = new Random();
        fortuneNumberChoosen = randomGenerator.nextInt(6) + 1;

        switch (fortuneNumberChoosen){
            case 1:
                System.out.println(fortune1);
                System.out.println(lotto1);
                break;
            case 2:
                System.out.println(fortune2);
                System.out.println(lotto2);
                break;
            case 3:
                System.out.println(fortune3);
                System.out.println(lotto3);
                break;
            case 4:
                System.out.println(fortune4);
                System.out.println(lotto4);
                break;
            case 5:
                System.out.println(fortune5);
                System.out.println(lotto5);
                break;
            case 6:
                System.out.println(fortune6);
                System.out.println(lotto6);
                break;

        }


    }
}
