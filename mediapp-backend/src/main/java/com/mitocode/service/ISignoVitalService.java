package com.mitocode.service;

import java.util.List;

import com.mitocode.model.SignoVital;



public interface ISignoVitalService {
	
	public SignoVital registrar(SignoVital signoVital);
	
	public SignoVital modificar(SignoVital signoVital);
	
	public List<SignoVital> listar();
	
	public SignoVital leerPorId(Integer id);
	
	public boolean eliminar(Integer id);
}
