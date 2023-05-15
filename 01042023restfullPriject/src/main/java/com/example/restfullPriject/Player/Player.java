package com.example.restfullPriject.Player;

import com.example.restfullPriject.waepon.Weapon;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "player")
public class Player {

    private long id;
    private String name;
    private int age;
    private int skill;
    private Weapon weapon;

    @Column (
            name = "id",
            updatable = false
    )
    @Id
    @SequenceGenerator(
            name = "Player_sequence",
            sequenceName = "Player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Player_sequence"
    )
    public long getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Weapon.class)
    @JoinColumn(name="weapon_id")
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public Player(String name, int age, int skill, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.skill = skill;
        this.weapon = weapon;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Player() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age &&
                skill == player.skill &&
                Objects.equals(name, player.name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", skill=" + skill +
                ", weapon=" + weapon +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, skill);
    }
}
