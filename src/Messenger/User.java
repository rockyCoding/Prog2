package Messenger;

public class User {

    private String handle, firstName, lastName;

    public User(String handle, String firstName, String lastName) {
        this.handle = handle;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        String fullName = getFirstName() + " " + getLastName();
        return fullName;
    }
}
