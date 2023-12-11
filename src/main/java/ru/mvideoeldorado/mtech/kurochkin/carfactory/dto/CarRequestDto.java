package ru.mvideoeldorado.mtech.kurochkin.carfactory.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class CarRequestDto {
    @NotNull(message = "car name cannot be null")
    @Size(max = 20, message = "name must have size < 20")
    private String name;
    @NotNull(message = "carBodyId cannot be null")
    public Long carBodyId;
    @Size(min = 2, message = "carWheelIds must have at least 2 elements")
    private Set<Long> carWheelIds;
}

