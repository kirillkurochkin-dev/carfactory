package ru.mvideoeldorado.mtech.kurochkin.carfactory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel.Wheel;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Long> {
}
