package com.api.springboot.desafio.services;

import com.api.springboot.desafio.models.Conversion;

public interface IConversionService {
	
	public Conversion aplicarTipoCambioMonto(float monto, String monedaOrigen, String monedaDestino);
		
	public Conversion create(Conversion conversion);
	
	public Conversion update(Conversion conversion);

}
