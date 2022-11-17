public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String pNumber;
    private String address;

    public Customer (String firstName, String lastName, String email, String pNumber, String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pNumber = pNumber;
        this.address = address;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return " First Name: " + firstName + "  Last Name: " + lastName + "   Email: " + email + "   Phone Number: " + pNumber + "   Address: " + address + "\n";
    }
}
