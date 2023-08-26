package com.mindhub.homebanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.mindhub.homebanking.repositories.*;
import com.mindhub.homebanking.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import  java.util.List;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByLastName(String lastName);
		}



