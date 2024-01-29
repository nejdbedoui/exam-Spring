package com.example.nejdndouitest.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "washing_service")
public class Washing_Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idService", nullable = false)
    private Long idService;

    @Column(name = "price")
    private Float price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @ManyToMany(mappedBy = "washing_Services")
    private Set<Reservation> reservations ;

}