package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEWS_DATA")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
