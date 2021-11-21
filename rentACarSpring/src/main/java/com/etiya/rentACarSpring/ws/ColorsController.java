package com.etiya.rentACarSpring.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.business.absracts.ColorService;
import com.etiya.rentACarSpring.business.requests.CreateColorRequest;
import com.etiya.rentACarSpring.business.requests.DeleteColorRequest;
import com.etiya.rentACarSpring.business.requests.UpdateColorRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.Color;

@RestController
@RequestMapping("api/colors")
public class ColorsController {

	private ColorService colorService;
	
	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	@GetMapping("check")
	public String Check() {
		return "API up";
	}
	
	@GetMapping("all")
	public List<Color> getAll(){
		return null;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CreateColorRequest createColorRequest) {
		return this.colorService.save(createColorRequest);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody UpdateColorRequest updateColorRequest) {
		return this.colorService.update(updateColorRequest);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}
}
