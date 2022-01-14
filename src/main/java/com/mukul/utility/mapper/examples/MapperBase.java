package com.mukul.utility.mapper.examples;

public interface MapperBase<E,M> {
    M entityToModel (E entity);

    E modelToEntity(M model);
}

