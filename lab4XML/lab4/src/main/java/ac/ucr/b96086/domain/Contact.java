package ac.ucr.b96086.domain;

import ac.ucr.b96086.persistence.PersistenceEntity;

import java.time.LocalDate;

public class Contact implements PersistenceEntity {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBrithday() {
        return brithday;
    }

    public void setBrithday(LocalDate brithday) {
        this.brithday = brithday;
    }

    private LocalDate brithday;

    @Override
    public String getId(){
        return name+ "-"+ surname;
    }
}
