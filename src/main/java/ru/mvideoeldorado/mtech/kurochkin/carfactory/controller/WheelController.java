package ru.mvideoeldorado.mtech.kurochkin.carfactory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel.Wheel;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.WheelService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CarWheel")
public class WheelController {
    private final WheelService wheelService;
    @GetMapping
    ResponseEntity<Iterable<Wheel>> getAllCarWheel() {
        Iterable<Wheel> carWheels = wheelService.getAllCarWheel();
        return ResponseEntity.ok(carWheels);
    }
}
