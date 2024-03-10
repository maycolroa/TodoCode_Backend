package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PaqueteTuristicoDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.PaqueteTuristico;
import com.hackacode.agenciaturistica.repository.IPaqueteTuristicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaqueteTuristicoService implements IPaqueteTuristicoService {

    @Autowired
    private IPaqueteTuristicoRepository paqueteTuristicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PaqueteTuristicoDTO> getAllPaquetesTuristicos() {
        List<PaqueteTuristico> paquetesTuristicos = paqueteTuristicoRepository.findAll();

        ArrayList<PaqueteTuristicoDTO> paquetesTuristicoDTO = new ArrayList<PaqueteTuristicoDTO>();

        for (PaqueteTuristico paqueteTuristico : paquetesTuristicos) {
            paquetesTuristicoDTO.add(modelMapper.map(paqueteTuristico,PaqueteTuristicoDTO.class));
        }

        return paquetesTuristicoDTO;
    }

    @Override
    public PaqueteTuristicoDTO getPaqueteTuristicoById(Long codigoPaquete) throws IdNotFoundException {
        PaqueteTuristico paqueteTuristico = paqueteTuristicoRepository.findById(codigoPaquete).orElseThrow(
                () -> new IdNotFoundException("El codigo " + codigoPaquete + " no se encuentra registrado")
        );

        PaqueteTuristicoDTO paqueteTuristicoDTO = modelMapper.map(paqueteTuristico, PaqueteTuristicoDTO.class);

        return paqueteTuristicoDTO;
    }

    @Override
    public PaqueteTuristicoDTO savePaqueteTuristico(PaqueteTuristicoDTO paqueteTuristicoDTO) throws HibernateOperationException {
        PaqueteTuristico paqueteTuristico = modelMapper.map(paqueteTuristicoDTO, PaqueteTuristico.class);

        try {
            paqueteTuristico = paqueteTuristicoRepository.save(paqueteTuristico);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibertane: " + e.getMessage());
        }

        PaqueteTuristicoDTO paqueteTuristicoDTOSave = modelMapper.map(paqueteTuristico, PaqueteTuristicoDTO.class);

        return paqueteTuristicoDTOSave;
    }

    public PaqueteTuristicoDTO editPaqueteTuristico(Long codigoPaquete, PaqueteTuristicoDTO paqueteTuristicoDTORecivido) throws IdNotFoundException, HibernateOperationException {
        PaqueteTuristicoDTO paqueteTuristicoDTO = this.getPaqueteTuristicoById(codigoPaquete);

        paqueteTuristicoDTO.setServicios(paqueteTuristicoDTORecivido.getServicios());

        this.savePaqueteTuristico(paqueteTuristicoDTO);

        return paqueteTuristicoDTO;
    }

    @Override
    public void deletePaqueteTuristicoById(Long codigoPaquete) throws IdNotFoundException {
        try {
            this.paqueteTuristicoRepository.deleteById(codigoPaquete);
        } catch (Exception e) {
            throw new IdNotFoundException("El id " + codigoPaquete + " no existe");
        }
    }
}
