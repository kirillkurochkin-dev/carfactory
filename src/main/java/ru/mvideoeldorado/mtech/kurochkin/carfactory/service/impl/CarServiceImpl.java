package ru.mvideoeldorado.mtech.kurochkin.carfactory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.car.CarMapper;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.dto.CarRequestDto;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.car.Car;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.exception.EntityNotFoundException;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.repository.CarRepository;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.CarService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "car")
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @CachePut(key = "#result.id")
    public Car createCar(CarRequestDto carRequestDto) {
        Car car = carMapper.carRequestDtoToCar(carRequestDto);
        car.setCreationDate(LocalDate.now(ZoneId.of("UTC+3")));
        return carRepository.save(car);
    }

    @Cacheable(unless = "#result == null")
    public Car getCarById(long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Car.class.getName()));
    }

    @Override
    public List<Car> getAll(PageRequest pageRequest) {
        return carRepository.findAll(pageRequest).getContent();
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteCarById(Long id) {
        carRepository.delete(getCarById(id));
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteAll() {
        carRepository.deleteAll();
    }
}
