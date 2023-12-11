package ru.mvideoeldorado.mtech.kurochkin.carfactory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.body.Body;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.BodyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carBody")
public class BodyController {
    private final BodyService bodyService;

    @GetMapping
    ResponseEntity<Iterable<Body>> getAllCarBody() {
        Iterable<Body> carBodies = bodyService.getAllCarBody();
        return ResponseEntity.ok(carBodies);
    }
}
