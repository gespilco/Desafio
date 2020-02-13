package com.api.springboot.desafio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversion")
public class Conversion {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

//	parámetros de entrada : monto, monedaOrigen, monedaDestino
	@Column(name = "monto", nullable = true)
	private float monto;
	
	@Column(name = "monedaOrigen", nullable = true)
	private String monedaOrigen;
	
	@Column(name = "monedaDestino", nullable = true)
	private String monedaDestino;
	
//  parámetros de salida : monto, montoTipoCambio, monedaOrigen, monedaDestino, tipoCambio	
	@Column(name = "montoConTipoCambio", nullable = true)
	private float montoConTipoCambio;
	
	@Column(name = "tipoCambio", nullable = true)
	private float tipoCambio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public float getMontoConTipoCambio() {
		return montoConTipoCambio;
	}

	public void setMontoConTipoCambio(float montoConTipoCambio) {
		this.montoConTipoCambio = montoConTipoCambio;
	}

	public float getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(float tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

}
