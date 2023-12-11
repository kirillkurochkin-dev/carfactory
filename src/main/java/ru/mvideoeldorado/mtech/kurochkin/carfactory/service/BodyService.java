package ru.mvideoeldorado.mtech.kurochkin.carfactory.service;


import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.body.Body;

import java.util.List;

public interface BodyService {

    List<Body> getAllCarBody();
    Body getCarBodyById(long id);
}
