package ru.mvideoeldorado.mtech.kurochkin.carfactory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.entity.body.Body;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.exception.EntityNotFoundException;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.repository.BodyRepository;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.service.BodyService;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "carWheel")
public class BodyServiceImpl implements BodyService {
    private final BodyRepository bodyRepository;

    @Override
    @Cacheable(unless = "#result == null")
    public List<Body> getAllCarBody() {
        return bodyRepository.findAll();
    }

    @Override
    @Cacheable(unless = "#result == null")
    public Body getCarBodyById(long id) {
        return bodyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Body.class.getName()));
    }
}
