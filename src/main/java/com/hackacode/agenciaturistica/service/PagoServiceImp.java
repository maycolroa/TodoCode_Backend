package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PagoReqDTO;
import com.hackacode.agenciaturistica.dto.PagoResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.Pago;
import com.hackacode.agenciaturistica.repository.IPagoRepository;
import com.hackacode.agenciaturistica.repository.IVentaServicioRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class PagoServiceImp implements IPagoService{

    @Autowired
    private IPagoRepository pagoRepo;



    @Autowired
    private IVentaPaqueteService ventaPaqServ;



    @Autowired
    private IVentaServicioSevice  ventaServServ;




    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<PagoResDTO> getAll() {
        var pagosBD = pagoRepo.findAll();
        var pagosDTO = new ArrayList<PagoResDTO>();

        for (Pago pago : pagosBD){
            pagosDTO.add(modelMapper.map(pago, PagoResDTO.class));

        }

        return pagosDTO;
    }

    @Override
    public PagoResDTO getPagoById(Long id_pago) throws IdNotFoundException {
        Pago pago= pagoRepo.findById(id_pago).orElseThrow(() -> new IdNotFoundException("El id " + id_pago + " no se encuentra registrado"));

        var pagoDto = modelMapper.map(pago, PagoResDTO.class);


        return pagoDto;
    }

    @Override
    public PagoResDTO savePagoServicio(@Valid @RequestBody PagoReqDTO pagoDto)throws HibernateOperationException {


        var pagosave = modelMapper.map(pagoDto, Pago.class);

        try{

            var ventaServ = ventaServServ.getVentaServicioById(pagoDto.getVenta().getNum_venta());

            pagosave.setMontoTotal(ventaServ.getServicio().getCosto());

            pagosave = pagoRepo.save(pagosave);

        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var pagoDtoSave = modelMapper.map(pagosave, PagoResDTO.class);

        return pagoDtoSave;

    }


    public PagoResDTO savePagoPaquete(@Valid @RequestBody PagoReqDTO pagoDto) throws HibernateOperationException {


        var pagosave = modelMapper.map(pagoDto, Pago.class);

        try{


            var ventaServ = ventaPaqServ.getVentaPaqueteById(pagoDto.getVenta().getNum_venta());

            pagosave.setMontoTotal(ventaServ.getPaquete().getCosto());


            pagosave = pagoRepo.save(pagosave);

        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var pagoDtoSave = modelMapper.map(pagosave, PagoResDTO.class);

        return pagoDtoSave;

    }

}
