package models;

public abstract class User {

    private int id;
    private String name;
    private String email;
    private String address;
    private String phonenumber;

    public User(String name, String email) {
        this.name=name;
        this.email=email;
        id++;
    }

    public User(int id, String name, String email, String address, String phonenumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        id++;
    }
    
    public abstract void showDataUser();

    @Override
    public String toString() {
        return "User: "+name+", Email: "+email+"\nAddress: "+address+" Phone: "+phonenumber+".";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        if (phonenumber.length()>8) {
            System.out.println("You must provide an 8 number phonenumber.");
        } else if (phonenumber.length()==8) {
            this.phonenumber = phonenumber;
        }
    }

}