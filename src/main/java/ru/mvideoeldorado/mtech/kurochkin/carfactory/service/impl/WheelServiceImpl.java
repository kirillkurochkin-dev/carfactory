package ru.mvideoeldorado.mtech.kurochkin.carfactory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.wheel.Wheel;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.repository.WheelRepository;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.WheelService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "carWheel")
public class WheelServiceImpl implements WheelService {
    private final WheelRepository wheelRepository;
    @Cacheable(unless = "#result == null")
    @Override
    public List<Wheel> getAllCarWheel() {
        return wheelRepository.findAll();
    }

    @Cacheable(unless = "#result == null")
    @Override
    public List<Wheel> getAllCarWheelByIds(Set<Long> ids) {
        return wheelRepository.findAllById(ids);
    }
}
