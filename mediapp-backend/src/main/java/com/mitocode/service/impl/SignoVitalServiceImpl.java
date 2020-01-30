package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.SignoVital;
import com.mitocode.repo.ISignoVitalRepo;
import com.mitocode.service.ISignoVitalService;

@Service
public class SignoVitalServiceImpl implements ISignoVitalService {
	
	@Autowired
	public ISignoVitalRepo repo;

	@Override
	public SignoVital registrar(SignoVital signoVital) {
		// TODO Auto-generated method stub
		return repo.save(signoVital);
	}

	@Override
	public SignoVital modificar(SignoVital signoVital) {
		// TODO Auto-generated method stub
		return repo.save(signoVital);
	}

	@Override
	public List<SignoVital> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public SignoVital leerPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<SignoVital> op = repo.findById(id);
		return op.isPresent() ? op.get() : new SignoVital();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}

}
