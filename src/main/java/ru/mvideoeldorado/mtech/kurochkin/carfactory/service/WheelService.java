package ru.mvideoeldorado.mtech.kurochkin.carfactory.service;


import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel.Wheel;

import java.util.List;
import java.util.Set;

public interface WheelService {
    List<Wheel> getAllCarWheel();
    List<Wheel> getAllCarWheelByIds(Set<Long> ids);
}
