/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.domain;


import ac.ucr.b96086.persistence.PersistenceEntity;
import java.time.LocalDate;

/**
 *
 * @author viviana
 */
public class Contact implements PersistenceEntity {

    private String name;
    private String surname;
    private LocalDate birthdate;

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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

  
    public String getId() {
        // Retornar un valor único UUID
        // Retornar una combinación de valores que hacen este registro único
        return name + "-" + surname;
    }
}
