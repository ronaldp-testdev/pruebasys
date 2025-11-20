package org.ronaldp.prueba.loginsys.domain.mappers;

public interface ICommonMapper<E,D>{
    D todto(E entity);
    E toEntity(D dto);
}
