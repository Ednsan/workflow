package com.workflow.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.workflow.domain.*;
import com.workflow.services.*;


@RestController
@RequestMapping(value="/skill")
public class SkillResource{
 
	@Autowired
	
	private SkillService skillService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Skill obj = skillService.find(id);
		
		return ResponseEntity.ok().body(obj);

	}


}


