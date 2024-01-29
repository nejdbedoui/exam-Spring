package com.example.nejdndouitest.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehicle", nullable = false)
    private Long idVehicle;

    @Column(name = "brand")
    private String brand;

    @Column(name = "immatriculation")
    private String immatriculation;

    @OneToMany()
    private Set<Reservation> reservations;

}