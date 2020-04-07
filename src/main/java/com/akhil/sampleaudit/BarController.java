package com.akhil.sampleaudit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarController {
	
	@Autowired
	IBarService barService;
	
	@PostMapping("/add/{name}")
	public String addBars(@PathVariable String name) {
		barService.addBar(new Bar(name));
		System.out.println("Added bars ---> syso");
		return "Added " + name +" bars";
	}
	
	@PutMapping("/update/{id}/{name}")
	public String updateBars(@PathVariable Integer id, @PathVariable String name) {
		//call update
		barService.updateBar(id, name);
		return "Updated " + id + " with "+ name;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBars(@PathVariable Integer id) {
		// call delete function
		barService.deleteBar(id);
		return "deleted " + id;
	}
	
}
