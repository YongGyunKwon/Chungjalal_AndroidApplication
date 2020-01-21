package com.example.firebasetest.data;

public class MapDTO {

    private String name;
    private String open_time;
    private String etc;
    private String location;
    private String phonenumber;
    private String type;

    public MapDTO(){

    }

    public MapDTO(String name,String open_time,String etc,String location,String phonenumber,String type)
    {
            this.name=name;
            this.open_time=open_time;
            this.etc=etc;
            this.location=location;
            this.phonenumber=phonenumber;
            this.type=type;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public void setOpen_time(String open_time)
    {
        this.open_time=open_time;
    }

    public String getOpen_time()
    {
        return open_time;
    }


    public void setEtc(String etc)
    {
        this.etc=etc;
    }
    public String getEtc()
    {
        return etc;
    }

    public void setLocation(String location)
    {
        this.location=location;
    }

    public String getLocation()
    {
        return location;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber=phonenumber;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setType(String type)
    {
        this.type=type;
    }

    public String getType(){
        return type;
    }
}
