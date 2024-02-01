package com.example.demo.SceduleMatch;

import com.example.demo.team.Team;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Match {

    @Id
    @SequenceGenerator(
            name = "match_sequence",
            sequenceName = "match_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "match_sequence"
    )
    private Long id;

    // Match name or title (e.g., "Friendly Match", "Championship Match", etc.)
    private String name;

    @ManyToOne
    @JoinColumn(name = "team1_id", nullable = false)
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team2_id", nullable = false)
    private Team team2;

    // Date and time of the match
    private LocalDateTime matchTime;

    // Additional match details (you can customize these fields based on your needs)
    private String venue;
    private String referee;
    // Add more fields as needed

    public Match() {
    }

    public Match(String name, Team team1, Team team2, LocalDateTime matchTime, String venue, String referee) {
        this.name = name;
        this.team1 = team1;
        this.team2 = team2;
        this.matchTime = matchTime;
        this.venue = venue;
        this.referee = referee;
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

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", matchTime=" + matchTime +
                ", venue='" + venue + '\'' +
                ", referee='" + referee + '\'' +
                '}';
    }
}
