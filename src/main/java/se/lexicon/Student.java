package se.lexicon;

import java.util.Objects;

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

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("id ").append(id).append("")
                .append("name ").append(name).append("")
                .append("email").append(email).append("")
                .append("address").append(address);

        return str.toString();
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, email, address);
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        } if(!(o instanceof Student)){
            return false;
        }
        Student field = (Student) o;
        return id== field.id && name.equals(field.name)
                && email.equals(field.email) && address.equals(field.address);
    }
}
