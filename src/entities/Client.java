package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {


    private String name;
    private String email;
    private Date birthDate;

    private static final SimpleDateFormat clientSdf = new SimpleDateFormat("dd/MM/yyyy");

    public Client(){

    }

    public Client(String name, String email, String sBirthDate) throws ParseException {
        this.name = name;
        this.email = email;
        this.birthDate = clientSdf.parse(sBirthDate);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String SBirthDate) throws ParseException {
        this.birthDate = clientSdf.parse(SBirthDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" (").append(clientSdf.format(birthDate)).append(")");
        sb.append(" - ").append(email);

        return sb.toString();
    }
}
