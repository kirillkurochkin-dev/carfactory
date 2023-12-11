package ru.mvideoeldorado.mtech.kurochkin.carfactory.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EntityNotFoundException extends RuntimeException {
    public static final String MESSAGE = "%s with id = %d not found.";

    private final Long entityId;
    private final String entity;

    @Override
    public String getMessage() {
        return String.format(MESSAGE, entity, entityId);
    }
}
