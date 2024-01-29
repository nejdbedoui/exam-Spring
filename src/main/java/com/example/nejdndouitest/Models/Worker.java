package com.example.nejdndouitest.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "worker")
public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgent", nullable = false)
    private Long idAgent;

    @Column(name = "name")
    private String name;

    @Column(name = "nic")
    private String nic;

    @OneToMany(mappedBy = "worker")
    private Set<Reservation> reservations ;

}