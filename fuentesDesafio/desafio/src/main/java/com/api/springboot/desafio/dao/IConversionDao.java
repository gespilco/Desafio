package com.api.springboot.desafio.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.springboot.desafio.models.Conversion;

public interface IConversionDao extends CrudRepository<Conversion, Long>
{

	@Query(value = "SELECT * FROM sistema.conversion c where c.monto=:monto and c.moneda_origen=:monedaOrigen and c.moneda_destino=:monedaDestino", nativeQuery = true)
	Conversion montoConTipoCambio(
			@Param("monto") float monto, 
			@Param("monedaOrigen") String monedaOrigen,
			@Param("monedaDestino") String monedaDestino);
	
}