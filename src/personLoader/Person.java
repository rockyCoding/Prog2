package personLoader;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String name;
    private Date birthDate;

    public Person(String name, String birthDateText) {
        this.name = name;

        try {
            birthDate = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US).parse(birthDateText);
        } catch (ParseException e) {
            birthDate = new Date();
        }
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Birthdate: " + birthDate;
    }
}
