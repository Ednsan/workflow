package com.workflow.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.workflow.domain.*;
import com.workflow.services.*;

import javassist.tools.rmi.ObjectNotFoundException;


@Controller
@RestController
@RequestMapping(value="/skill")
public class SkillResource{
 
	@Autowired	
	private SkillService skillService;
	
	//OBTEM UMA SKILL VIA GET
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Skill> find(@PathVariable Integer id) {
		Skill obj = skillService.find(id);

		return ResponseEntity.ok().body(obj);

	}
	//CRIA UMA SKILL VIA POST
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Skill obj) {
	obj = skillService.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
}
	//ATUALIZA UMA SKILL VIA PUT
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Skill obj, @PathVariable Integer id){
		obj.setId(id);
		obj = skillService.update(obj);
		return ResponseEntity.noContent().build();
	}
}







