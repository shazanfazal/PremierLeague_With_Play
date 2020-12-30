package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DateAndTimeTest {

    //throws Errors if any of the instance variables are violated.
    @Test
    public void errorMessageThrownIfDateNotApplicable(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DateAndTime dateAndTimeTest = new DateAndTime(0,14,2026,0,62);
        });
    }

    //it will not throw any error if the test is passed
    @Test
    public void allTestPassCheck(){
       Assertions.assertDoesNotThrow(() -> {
           new DateAndTime(1,12,2020,3,30);
       });
    }

}
