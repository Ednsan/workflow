package com.workflow.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.workflow.domain.*;
import com.workflow.dto.SkillDTO;
import com.workflow.repositories.*;
import com.workflow.repositories.SkillRepository;
import com.workflow.services.exceptions.*;;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepo; 
	

	public Skill find(Integer id) {
		Optional<Skill> obj = skillRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id : " + id + " Skill  : " + Skill.class.getName()));
	}
	
	public Skill insert(Skill obj) {
		obj.setId(null);
		return skillRepo.save(obj);
	}
	
	public Skill update(Skill obj) {
		find(obj.getId());
		return 	skillRepo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			skillRepo.deleteById(id);
		}
		catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Skill> findAll() {
		return skillRepo.findAll();
	}
	
	public Page<Skill> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return skillRepo.findAll(pageRequest);
	}

	public Skill fromDTO(SkillDTO objDto) {
		return new Skill(objDto.getId(), objDto.getName(), objDto.getSpecialization());
	}
}
