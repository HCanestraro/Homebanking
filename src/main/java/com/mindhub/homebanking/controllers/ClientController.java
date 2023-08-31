package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientLoanRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {
        @Autowired
        private ClientRepository clientRepository;

        @GetMapping("/clients")
        public List<ClientDTO> getClients() {
            return clientRepository.findAll().stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
        }

        @GetMapping("/clients/{id}")
        public ClientDTO getClientById(@PathVariable long id){
            return new ClientDTO(clientRepository.findById(id).get());
        }

        @Autowired
        private PasswordEncoder passwordEncoder;

        @RequestMapping(path = "/clients", method = RequestMethod.POST)
        public ResponseEntity<Object> register(

                @RequestParam String firstName,
                @RequestParam String lastName,
                @RequestParam String email,
                @RequestParam String password) {
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {

                return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);

            }

            if (clientRepository.findByEmail(email) !=  null) {
                return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
            }

            clientRepository.save(new Client(firstName, lastName, email, passwordEncoder.encode(password)));

            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        @RequestMapping("/clients/current")
        public ClientDTO getAll(Authentication authentication) {

            return new ClientDTO(clientRepository.findByEmail(authentication.getName()));

        }

    }
