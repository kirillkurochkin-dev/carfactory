package ru.mvideoeldorado.mtech.kurochkin.carfactory.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.dto.CarRequestDto;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.car.Car;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
@Validated
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(carService.getAll(PageRequest.of(page, size)));
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarRequestDto carRequestDto) {
        return ResponseEntity.ok(carService.createCar(carRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping()
    public ResponseEntity deleteAll() {
        carService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
