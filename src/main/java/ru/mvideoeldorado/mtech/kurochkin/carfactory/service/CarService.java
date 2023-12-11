package ru.mvideoeldorado.mtech.kurochkin.carfactory.service;

import org.springframework.data.domain.PageRequest;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.dto.CarRequestDto;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.car.Car;


import java.util.List;

public interface CarService {
    Car createCar(CarRequestDto carRequestDto);
    Car getCarById(long id);
    List<Car> getAll(PageRequest pageRequest);
    void deleteCarById(Long id);
    void deleteAll();
}
