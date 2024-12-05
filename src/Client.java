public class Client {
    private String FirtsName;
    private String LastName;

    public Client(String firtsname, String lastname){
        this.FirtsName = firtsname;
        this.LastName = lastname;
    }

    public String getFirtsName() {
        return FirtsName;
    }

    public void setFirtsName(String firtsName) {
        FirtsName = firtsName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
