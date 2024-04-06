package Model;

public class Parcipant {

    private String firstName;
    private String secondName;
    private String phone;

    public Parcipant(String firstName, String secondName, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return firstName + ' ' +
                secondName +
                ", телефон " + phone;
    }

    public String preparationSaveToFile() {
        return firstName + " " + secondName + " " + phone + "\n";
    }
}
