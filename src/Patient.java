public class Patient {

    private String name;
    private String email;
    private String address;
    private String phonenumber;
    private String birthday;
    private Double weight;
    private Double height;
    private String blood;

    public Patient(String name, String email) {
        this.name=name;
        this.email=email;
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

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getWeight() {
        return this.weight;
    }

    public String getWeightKg() {
        return this.weight+" Kg.";
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return this.height;
    }

    public String getHeightM() {
        return this.height+" Mts.";
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getBlood() {
        return this.blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

}
