package com.Dojos_Ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Dojos_Ninjas.models.Dojo;
import com.Dojos_Ninjas.models.Ninja;
import com.Dojos_Ninjas.repositories.dojoRepository;
import com.Dojos_Ninjas.repositories.ninjaRepository;

@Service
public class DojoNinja_Services {

	
	private dojoRepository dojoRepo;
	private ninjaRepository ninjaRepo;


	public DojoNinja_Services(dojoRepository dojoRepo, ninjaRepository ninjaRepo) {
		super();
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	//Make a Dojo
	public Dojo create(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
	
	//Make a Ninja
	public Ninja create (Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	//Display Dojos
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	//Display Ninjas
	public List<Ninja> getAllNinjas(){
		return (List<Ninja>) ninjaRepo.findAll();
	}
	//Display one Dojo
	public Dojo getDojo(Long id) {
		Optional<Dojo> optionalDojo = this.dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
}
