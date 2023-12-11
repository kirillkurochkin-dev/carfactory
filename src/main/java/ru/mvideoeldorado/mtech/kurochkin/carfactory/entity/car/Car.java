package ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.car;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.body.Body;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel.Wheel;

import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Body body;
    @ManyToMany
    @JoinTable(
            name = "car_wheel",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "wheel_id")
    )
    private List<Wheel> wheels;
    private LocalDate creationDate;
}