package com.example.restfullPriject.waepon;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table (name = "weapon")
public class Weapon {

    private long id;
    private String name;
    private int damage;
    private int calibre;

    public Weapon(String name, int damage, int calibre) {
        this.name = name;
        this.damage = damage;
        this.calibre = calibre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return id == weapon.id && damage == weapon.damage && calibre == weapon.calibre && Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, damage, calibre);
    }


    @Column
    @Id
    @SequenceGenerator(
            name = "Weapon_sequence",
            sequenceName = "Weapon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Weapon_sequence"
    )
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Column
    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", calibre=" + calibre +
                '}';
    }

    public Weapon() {
    }
}
