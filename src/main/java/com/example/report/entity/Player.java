package com.example.report.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "players", schema = "public")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    private Long id;

    @Column(name = "display_first_last")
    String displayFirstLast;

    @Column(name = "display_last_comma_first")
    String displayLastCommaFirst;

    @Column(name = "from_year")
    Integer fromYear;

    @Column(name = "games_played_flag")
    String gamesPlayedFlag;

    @Column(name = "otherleague_experience_ch")
    Integer otherleagueExperienceCh;

    @Column(name = "person_id")
    Integer personId;

    @Column(name = "playercode")
    String playercode;

    @Column(name = "rosterstatus")
    Integer rosterstatus;

    @Column(name = "team_abbreviation")
    String teamAbbreviation;

    @Column(name = "team_city")
    String teamCity;

    @Column(name = "team_code")
    String teamCode;

    @Column(name = "team_id")
    Long teamId;

    @Column(name = "team_name")
    String teamName;

    @Column(name = "to_year")
    Integer toYear;
}
