package com.company;

public class Doctor extends Person
{
    private int yearsOfEx ;
    private int roomNumber;

    public Doctor(String lastName, String id, String userName, String password, String email, String firstName, int yearsOfEx, int roomNumber) {
        super(lastName, id, userName, password, email, firstName);
        this.yearsOfEx = yearsOfEx;
        this.roomNumber = roomNumber;
    }


    //amit comment
    protected void setYears(int value)
    {
        yearsOfEx=value;
    }

    protected void setRoom(int room )
    {
        roomNumber=room;
    }

    protected int getYears()
    {
        return yearsOfEx;
    }

    protected int getRoom()
    {
        return roomNumber;
    }
}
