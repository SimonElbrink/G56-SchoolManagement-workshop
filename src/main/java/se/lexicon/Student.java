package se.lexicon;

public class Student {
//    id: int
//    name: String
//    email: String
//    address: String
    private final int id;
    private String name;
    private String email;
    private String address;

    public Student(int id, String name, String email, String address){
        this.id = id;
        setName(name);
        setEmail(email);
        setAddress(address);
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
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
