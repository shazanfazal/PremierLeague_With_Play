package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MatchTest {

    //checking success message if the Match is created
    @Test
    public void checkSuccessOfCreatingMatch(){
        Assertions.assertDoesNotThrow(() -> {
            new Match("Chelsea","Arsenal",1,2,new DateAndTime(2,9,2016,12,45));
        });
    }

}
