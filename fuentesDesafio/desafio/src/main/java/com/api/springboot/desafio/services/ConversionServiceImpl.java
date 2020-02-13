package com.api.springboot.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.springboot.desafio.dao.IConversionDao;
import com.api.springboot.desafio.models.Conversion;

@Service
public class ConversionServiceImpl implements IConversionService
{
	@Autowired
	private IConversionDao conversionDao;

	@Override
	public Conversion aplicarTipoCambioMonto(float monto, String monedaOrigen, String monedaDestino) {
		return conversionDao.montoConTipoCambio(monto, monedaOrigen, monedaDestino);
	}
	
	@Override
	public Conversion create(Conversion conversion) {
		Conversion createConversion=conversionDao.save(conversion);
		return createConversion;
	}

	@Override
	public Conversion update(Conversion conversion) {
		Conversion updateConversion=conversionDao.findById(conversion.getId()).get();
		updateConversion.setTipoCambio(conversion.getTipoCambio());
		updateConversion.setMontoConTipoCambio(updateConversion.getMonto()*updateConversion.getTipoCambio());
		conversionDao.save(updateConversion);
		return updateConversion;
	}

}
