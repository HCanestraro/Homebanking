package com.mindhub.homebanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.mindhub.homebanking.models.*;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository < Account, Long >  {
	/* */
}