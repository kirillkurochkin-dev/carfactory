package ru.mvideoeldorado.mtech.kurochkin.carfactory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.car.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}