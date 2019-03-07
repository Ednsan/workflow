package com.workflow.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.workflow.dto.*;

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
	public ResponseEntity<Void> insert(@Valid @RequestBody SkillDTO objDto) {
	Skill obj = skillService.fromDTO(objDto);
	obj = skillService.insert(obj); 
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
}
	
	//ATUALIZA UMA SKILL VIA PUT
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SkillDTO objDto, @PathVariable Integer id){
		Skill obj = skillService.fromDTO(objDto);
		obj.setId(id);
		obj = skillService.update(obj);
		return ResponseEntity.noContent().build();
	}

	//DELETA UMA SKILL VIA DELETE
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		skillService.delete(id);
		return ResponseEntity.noContent().build();
}
	
	//LISTAR TODAS SKILLS 
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SkillDTO>> findAll(){
		List<Skill> list = skillService.findAll();
		List<SkillDTO> listDto = list.stream().map(obj -> new SkillDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	//PAGINAÇÃO CUSTOMIZADA POR PARAMETROS
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<SkillDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="name") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Skill> list = skillService.findPage(page, linesPerPage, orderBy, direction);
		Page<SkillDTO> listDto = list.map(obj -> new SkillDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
}







