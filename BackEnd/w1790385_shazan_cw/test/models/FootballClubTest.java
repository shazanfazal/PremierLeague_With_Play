package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FootballClubTest {

    //unit testing for FootballClub will send an error if values are violated
    //This will throw an Error Because Street and city is empty
    @Test
    public void checkErrorIfInAppropriateValuesWhenCreatingAClub(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FootballClub footballClubTest = new FootballClub(1,"Lampard","Chelsea","","",1245);
        });
    }

    //unit testing for successfully creating a FootballClub
    @Test
    public void checkPassMessageIfAllPass(){
        Assertions.assertDoesNotThrow(() -> {
            new FootballClub(2,"mikel","Arsenal","England","London",9461);
        });

    }
}
