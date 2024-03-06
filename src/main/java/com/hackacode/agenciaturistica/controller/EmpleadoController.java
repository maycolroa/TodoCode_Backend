package com.hackacode.agenciaturistica.controller;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.dto.EmpleadoDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/all")
    public List<EmpleadoDTO> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{idEmpleado}")
    public EmpleadoDTO getEmpleadoById(@PathVariable Long idEmpleado) throws IdNotFoundException {
        return empleadoService.getEmpleadoById(idEmpleado);
    }

    @PostMapping("/save")
    public EmpleadoDTO saveEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) throws HibernateOperationException {
        return empleadoService.saveEmpleado(empleadoDTO);
    }

    @PutMapping("/{idEmpleado}")
    public EmpleadoDTO editEmpleado(@PathVariable Long idEmpleado, @RequestBody EmpleadoDTO empleadoDTO) throws HibernateOperationException, IdNotFoundException {
        return empleadoService.editEmpleado(idEmpleado, empleadoDTO);
    }

    @DeleteMapping("/{idEmpleado}")
    public void deleteEmpleadoById(@PathVariable Long idEmpleado) throws IdNotFoundException {
        this.empleadoService.deleteEmpleadoById(idEmpleado);
    }
}
