package com.Sahil.Springbootassignment.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Question {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String question;

    //will store options in string format for eg :- 1_2_3_4 seperated by underscore
    private String options;

    //right option index
    private int rightAnswer;

    @ManyToOne
    @JoinColumn
    Quiz quiz;
}
