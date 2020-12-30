package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class PremierLeagueManagerTest {

    private final ArrayList<FootballClub> arrayListTest = new ArrayList<>();

    //adding data to the array
    @BeforeEach
    public void updatingArrayListWithData(){
        FootballClub footballClubTest = new FootballClub(1,"mikel","Arsenal","England","London",2586);
        arrayListTest.add(footballClubTest);

        FootballClub footballClubTest2 = new FootballClub(2,"lampard","Chelsea","England","London",8714);
        arrayListTest.add(footballClubTest2);

        FootballClub footballClubTest3 = new FootballClub(3,"klopp","Liverpool","London","liverpool",2987);
        arrayListTest.add(footballClubTest3);
    }

    //checking if the arrayList is updated.
    @Test
    public void checkTheArrayListSize(){
        Assertions.assertEquals(3,arrayListTest.size());
    }

    //removing data from the array the first element.
    @Test
    public void  removeFromArrayList(){
        //removing from the Array List and checking the Size
        for (FootballClub f : arrayListTest){
            arrayListTest.remove(f);
            break;
        }
        Assertions.assertEquals(2,arrayListTest.size());
    }






}
