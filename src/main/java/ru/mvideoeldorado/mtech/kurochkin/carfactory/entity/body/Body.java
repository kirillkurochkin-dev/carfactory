package ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.body;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.body.enums.BodyType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    BodyType bodyType;
    @NotNull(message = "Number of doors cannot be null")
    @Min(value = 2, message = "Car must have at least {value} doors")
    @Max(value = 6, message = "Car cannot have more than {value} doors")
    @Column(name = "number_of_doors")
    private Integer numberOfDoors;
    @Positive(message = "Weight must be a positive number")
    @Column(name = "weight")
    private Double weight;
    @Positive(message = "Height must be a positive number")
    @Column(name = "height")
    private Double height;
}
