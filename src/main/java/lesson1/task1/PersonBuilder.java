package lesson1.task1;

public class PersonBuilder {
    private Person person;

    public PersonBuilder() {
        person = new Person();
    }

    public PersonBuilder setInitials(String firstName, String lastName){
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return this;
    }

    public PersonBuilder setMiddleName(String middleName){
        person.setMiddleName(middleName);
        return this;
    }

    public PersonBuilder setCountry(String country){
        person.setCountry(country);
        return this;
    }

    public PersonBuilder setAddress(String address){
        person.setAddress(address);
        return this;
    }

    public PersonBuilder setPhone(String phone){
        person.setPhone(phone);
        return this;
    }

    public PersonBuilder setAge(int age){
        person.setAge(age);
        return this;
    }

    public PersonBuilder setGender(String gender){
        person.setGender(gender);
        return this;
    }

    public Person build(){
        return person;
    }
}
