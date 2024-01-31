package com.example.demo.team;

import jakarta.persistence.*;

@Entity
@Table
public class Team {

    @Id
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize=1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "team_sequence"
    )
    private Long id;
    private String name;

    public Team() {
    }

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
