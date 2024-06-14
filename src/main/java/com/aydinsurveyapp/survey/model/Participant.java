package com.aydinsurveyapp.survey.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="participant")
public class Participant {

    public Integer getId() {
        return this.participantId; 
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id", nullable = false)
    private Integer participantId;

    @Column(name ="first_name", length = 70, nullable = false)
    private String firstName;

    @Column(name= "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name= "email", nullable = false)
    private String eMail;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="participant")
    private List<Answer> answers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "participant")
    private List<SurveyParticipant> surveryParticipants;

 
}

