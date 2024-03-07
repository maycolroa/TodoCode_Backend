package com.hackacode.agenciaturistica.util;

import java.lang.reflect.Constructor;

public interface IMyFactory {

    public Object crearEntidad(String nombreEntidad);
}