package se.lexicon;

public class Student {
    private int id;
    private String name;
    private String email;
    private String address;

    public Student (int id, String name, String email, String address) {
        if(id==0){
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if(email==null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if(address==null || address.trim().isEmpty()){
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        this.id=id;
        this.name=name;
        this.email=email;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
