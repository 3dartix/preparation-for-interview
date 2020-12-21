package lesson1.task1;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .setInitials("Василий", "Петров")
                .setGender("М")
                .setCountry("Москва")
                .setPhone("12315235")
                .build();

        log.info("" + person);
    }
}
