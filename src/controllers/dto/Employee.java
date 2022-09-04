package controllers.dto;

public class Employee {
    private int id;
    private String name;
    private int pin;
    private String role;

    public int getid()
    {
        return this.id;
    }
    public void setid(int value)
    {
        this.id = value;
    }

    public String getname()
    {
        return this.name;
    }
    public void setname(String value)
    {
        this.name = value;
    }

    public int getpin()
    {
        return this.pin;
    }
    public void setpin(int value)
    {
        this.pin = value;
    }

    public String getrole()
    {
        return this.role;
    }
    public void setrole(String value)
    {
        this.role = value;
    }


    public Employee(int id,String name,int pin,String role)
    {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.role = role;
    }
}
