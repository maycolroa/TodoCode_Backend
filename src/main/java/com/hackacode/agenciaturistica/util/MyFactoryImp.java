package com.hackacode.agenciaturistica.util;

import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Service
public class MyFactoryImp implements IMyFactory {
    @Override
    public Object crearEntidad(String nombreEntidad) {
        try {


            Class<?> entidadClass = Class.forName(nombreEntidad);

            Constructor<?> constructor = entidadClass.getDeclaredConstructor();

                return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new IllegalArgumentException("Error al crear la entidad: " + e.getMessage());
        }
    }
}
