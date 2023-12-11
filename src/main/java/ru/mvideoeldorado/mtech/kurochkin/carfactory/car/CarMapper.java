package ru.mvideoeldorado.mtech.kurochkin.carfactory.car;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.dto.CarRequestDto;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.car.Car;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.WheelService;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.impl.BodyServiceImpl;

@RequiredArgsConstructor
@Component
public class CarMapper {
    private final BodyServiceImpl bodyService;
    private final WheelService wheelService;
    public Car carRequestDtoToCar(CarRequestDto carRequestDto) {

        return Car.builder()
                .name(carRequestDto.getName())
                .body(bodyService.getCarBodyById(carRequestDto.getCarBodyId()))
                .wheels(wheelService.getAllCarWheelByIds(carRequestDto.getCarWheelIds()))
                .build();
    }
}
