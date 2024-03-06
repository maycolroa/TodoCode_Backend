package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.dto.EmpleadoDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.Empleado;
import com.hackacode.agenciaturistica.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService{

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmpleadoDTO> getAllEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();

        ArrayList<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();

        for (Empleado empleado : empleados) {
            empleadosDTO.add(modelMapper.map(empleado,EmpleadoDTO.class));
        }

        return empleadosDTO;
    }

    @Override
    public EmpleadoDTO getEmpleadoById(Long idEmpleado) throws IdNotFoundException {
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElseThrow(
                () -> new IdNotFoundException("El id " + idEmpleado + " no se encuentra registrado")
        );

        EmpleadoDTO empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);

        return empleadoDTO;
    }

    @Override
    public EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO) throws HibernateOperationException {
        Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);

        try {
            empleado = empleadoRepository.save(empleado);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibertane: " + e.getMessage());
        }

        EmpleadoDTO empleadoDtoSave = modelMapper.map(empleado, EmpleadoDTO.class);

        return empleadoDtoSave;
    }

    public EmpleadoDTO editEmpleado(Long idEmpleado, EmpleadoDTO empleadoDTORecivido) throws IdNotFoundException, HibernateOperationException {
        EmpleadoDTO empleadoDTO = this.getEmpleadoById(idEmpleado);

        empleadoDTO.setNombre(empleadoDTORecivido.getNombre());
        empleadoDTO.setApellido(empleadoDTORecivido.getApellido());
        empleadoDTO.setDireccion(empleadoDTORecivido.getDireccion());
        empleadoDTO.setDni(empleadoDTORecivido.getDni());

        // Crear una LocalDate para una fecha específica
        //LocalDate fechaEspecífica = LocalDate.of(2024, 12, 31);
        empleadoDTO.setFecha_nac(empleadoDTORecivido.getFecha_nac());
        empleadoDTO.setNacionalidad(empleadoDTORecivido.getNacionalidad());
        empleadoDTO.setCelular(empleadoDTORecivido.getCelular());
        empleadoDTO.setEmail(empleadoDTORecivido.getEmail());
        empleadoDTO.setCargo(empleadoDTORecivido.getCargo());
        empleadoDTO.setSueldo(empleadoDTORecivido.getSueldo());

        this.saveEmpleado(empleadoDTO);

        return empleadoDTO;
    }

    @Override
    public void deleteEmpleadoById(Long idEmpleado) throws IdNotFoundException {
        try {
            this.empleadoRepository.deleteById(idEmpleado);
        } catch (Exception e) {
            throw new IdNotFoundException("El id " + idEmpleado + " no existe");
        }
    }
}
