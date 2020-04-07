package com.akhil.sampleaudit;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarService implements IBarService{
	
	@Autowired
	BarRepo barRepo;
	
	
	@Override
	public void addBar(Bar bar) {
		barRepo.save(bar);
	}


	@Override
	public void updateBar(Integer id, String name) {
		Optional<Bar> bar = barRepo.findById(id);
		bar.ifPresent(b -> {
			b.setName(name);
			barRepo.save(b);
			});
	}


	@Override
	public void deleteBar(Integer id) {
		Optional<Bar> bar = barRepo.findById(id);
		bar.ifPresent(b -> {
			barRepo.delete(b);
		});
		
	}
	
}
