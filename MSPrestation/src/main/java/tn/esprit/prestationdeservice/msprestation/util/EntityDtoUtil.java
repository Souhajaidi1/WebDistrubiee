package tn.esprit.prestationdeservice.msprestation.util;

import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static <D, E> D convertToDTO(E entity, Class<D> dtoClass) {
        D dto = null;
        try {
            dto = dtoClass.newInstance();
            BeanUtils.copyProperties(entity, dto);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public static <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        E entity = null;
        try {
            entity = entityClass.newInstance();
            BeanUtils.copyProperties(dto, entity);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static <D, E> void updateEntity(D dto, E entity) {
        BeanUtils.copyProperties(dto, entity);
    }
}
