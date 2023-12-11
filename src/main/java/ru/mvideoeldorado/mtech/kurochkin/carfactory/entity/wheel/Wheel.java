package ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel.enums.WheelColor;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel.enums.WheelType;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "wheel_type")
    private WheelType wheelType;
    @NotNull
    @Column(name = "is_broken")
    private Boolean isBroken;
    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private WheelColor color;
    @Size(max = 255, message = "Wheel brand must be at most {max} characters long")
    @Column(name = "brand")
    private String brand;
    @Past(message = "Manufacturing date must be in the past")
    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;
    @Future(message = "Warranty expiry date must be in the future")
    @Column(name = "warranty_expiry_date")
    private LocalDate warrantyExpiryDate;
}
