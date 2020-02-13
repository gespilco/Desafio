package com.api.springboot.desafio.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.desafio.models.Conversion;
import com.api.springboot.desafio.services.IConversionService;

@RestController
@RequestMapping("/conversion-controller")
public class ConversionController {
	@Autowired
	private IConversionService microservice;
	
	@GetMapping(value = "/aplicatipocambioamonto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conversion> tipoCambioaMonto(
			@RequestParam(value = "monto", required = false) float monto,
			@RequestParam(value = "monedaOrigen", required = false) String monedaOrigen,
			@RequestParam(value = "monedaDestino", required = false) String monedaDestino) {

		Conversion conversion = microservice.aplicarTipoCambioMonto(monto, monedaOrigen, monedaDestino);
		
		return new ResponseEntity<Conversion>(conversion, HttpStatus.OK);

	}
	
	@PostMapping(value = "/creatipocambio", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody Conversion conversion) {
		Map<String, Object> response = new HashMap<>();
		try {
			Conversion actualizaConversion = microservice.create(conversion);
			return new ResponseEntity<Conversion>(actualizaConversion, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/actualizatipocambio", produces = "application/json")
	public ResponseEntity<?> update(@RequestBody Conversion conversion) {
		Map<String, Object> response = new HashMap<>();
		try {
			Conversion actualizaConversion = microservice.update(conversion);
			return new ResponseEntity<Conversion>(actualizaConversion, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
