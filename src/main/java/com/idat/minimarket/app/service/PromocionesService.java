package com.idat.minimarket.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.minimarket.app.dao.PromocionesDao;
import com.idat.minimarket.app.model.Promociones;

@Service
@Transactional
public class PromocionesService {

	@Autowired
	private PromocionesDao dao;
	
	public List<Promociones> findAll(){
		return (List<Promociones>) dao.findAll();
	}
	
	public Promociones crear(Promociones promociones) {
		return dao.save(promociones);
	}
	
	public List<Object[]> obtenerPromocionesArray(){
        return dao.obtenerPromociones();
    }
	
	public Promociones buscarPorId(Integer id) {
		Optional<Promociones> promociones = dao.findById(id);
		
		if (promociones.isPresent())
   		  return dao.findById(id).get();
		else
			return null;
	}
	
	public Promociones update(Promociones promociones) {
		Promociones actualPromociones = dao.findById(promociones.getId()).get();
		actualPromociones.setId(promociones.getId());
		actualPromociones.setNombre_producto(promociones.getNombre_producto());
		actualPromociones.setPrecio_normal(promociones.getPrecio_normal());
		actualPromociones.setPrecio_oferta(promociones.getPrecio_oferta());
		actualPromociones.setUrl(promociones.getUrl());
		return dao.save(actualPromociones);
	}
}
