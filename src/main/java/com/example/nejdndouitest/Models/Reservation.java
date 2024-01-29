package com.example.nejdndouitest.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation", nullable = false)
    private Long idReservation;

    @Column(name = "timereservation")
    private LocalDateTime timereservation;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;



    @ManyToMany
    private Set<Washing_Service> washing_Services;

    @ManyToOne
    private Worker worker;

}