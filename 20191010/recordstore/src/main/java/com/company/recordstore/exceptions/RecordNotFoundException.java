package com.company.recordstore.exceptions;

public class RecordNotFoundException extends RuntimeException {
        public RecordNotFoundException(String thisIsTheMessage) {
            super("The message from the RecordNotFoundException is " + thisIsTheMessage);
        }

        //Could do this. But just because you can doesn't mean you should!
//    public int doSomeAddition(int x, int y) {
//        return x + y;
//    }

}
