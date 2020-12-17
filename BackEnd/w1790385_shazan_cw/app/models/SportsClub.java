package models;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {

    private int regNoOfClub;
    private String coachName;
    private String clubName;
    private String streetOfTheClub;  //since we should know the location i have divided the address into 3 parts;
    private String cityOfTheClub;
    private int postCodeOfTheStreet;
    protected String errorMessageOFLength = " Sorry the input length is too small";

    //Default Constructor
    public SportsClub(){

    }

    //parameterized Constructor
    public SportsClub(int regNoOfClub,String coachName, String clubName, String streetOfTheClub, String cityOfTheClub, int postCodeOfTheStreet){
        setRegNoOfClub(regNoOfClub);
        setCoachName(coachName);
        setClubName(clubName);
        setStreetOfTheClub(streetOfTheClub);
        setCityOfTheClub(cityOfTheClub);
        setPostCodeOfTheStreet(postCodeOfTheStreet);

    }
    //getters of the above instance variables

    public int getRegNoOfClub(){
        return this.regNoOfClub;
    }

    public String getCoachName(){
        return this.coachName;
    }
    public String getClubName(){
        return this.clubName;
    }

    public String getStreetOfTheClub(){
        return this.streetOfTheClub;
    }

    public String getCityOfTheClub(){
        return this.cityOfTheClub;
    }

    public int getPostCodeOfTheStreet(){
        return this.postCodeOfTheStreet;
    }

    //Setters of the above instance variables

    public void setRegNoOfClub(int regNoOfClub){
        if(regNoOfClub < 0){
            throw new IllegalArgumentException(" Enter above 0");
        }else{
            this.regNoOfClub = regNoOfClub ;
        }
    }

    public void setCoachName(String coachName){
        if(coachName.length() <= 1){
            throw new IllegalArgumentException(errorMessageOFLength);
        }else{
            this.coachName= coachName;
        }
    }

    public void setClubName(String clubName){
        if(clubName.length() <= 1){
            throw new IllegalArgumentException(errorMessageOFLength);

        }else{
            this.clubName = clubName;
        }
    }

    public void setStreetOfTheClub(String streetOfTheClub){
        if(streetOfTheClub.length() <= 1){
            throw new IllegalArgumentException(errorMessageOFLength);

        }else{
            this.streetOfTheClub = streetOfTheClub;
        }
    }

    public void setCityOfTheClub(String cityOfTheClub){
        if(cityOfTheClub.length() <= 2){
            throw new IllegalArgumentException(errorMessageOFLength);

        }else {
            this.cityOfTheClub = cityOfTheClub;
        }
    }

    public void setPostCodeOfTheStreet(int postCodeOfTheStreet){
        if(postCodeOfTheStreet < 0 ){
            throw new IllegalArgumentException(errorMessageOFLength);
        }else{
            this.postCodeOfTheStreet = postCodeOfTheStreet;
        }
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;
        if (otherObj == null || getClass() != otherObj.getClass()) return false;

        SportsClub thatSportClub = (SportsClub) otherObj;

        if (regNoOfClub != thatSportClub.regNoOfClub) return false;
        if (!coachName.equals(thatSportClub.coachName)) return false;
        return clubName.equals(thatSportClub.clubName);
    }

    @Override
    public int hashCode() {
        int result = regNoOfClub;
        result = 31 * result + coachName.hashCode();
        result = 31 * result + clubName.hashCode();
        return result;
    }

    //to string method
    @Override
    public String toString(){
        return " Club Name: " + this.clubName + " , Coach Name: " + this.coachName + ", Registration No: " + this.regNoOfClub + ", Address - Street: " +  this.streetOfTheClub + ", City: " + this.cityOfTheClub + ", postcode: " + this.postCodeOfTheStreet;
    }
}
