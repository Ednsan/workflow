package com.workflow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workflow.domain.*;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{


}
