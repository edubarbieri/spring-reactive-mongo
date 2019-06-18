package br.com.edubarbieri.logapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.edubarbieri.logapi.model.Profile;
import br.com.edubarbieri.logapi.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Profile> create(@RequestBody Profile user) {
        log.debug("create user with user : {}", user);
        return profileService.createUser(user);
    }
    
    @PutMapping("/{id}")
    public Mono<Profile> updateUser(@RequestBody Profile user, @PathVariable String id) {
        log.debug("updateUser User with id : {} and blog : {}", id, user);
        return profileService.updateUser(user, id);
    }
    
    @GetMapping("/find-by-email")
    public Flux<Profile> findByEmail(@RequestParam String email) {
        log.debug("findByEmail User with email : {}", email);
        return profileService.findByEmail(email);
    }
    
    @GetMapping("/find-by-legal-document")
    public Flux<Profile> findByLegalDocument(@RequestParam String legalDocument) {
        log.debug("findByLegalDocument User with email : {}", legalDocument);
        return profileService.findByEmail(legalDocument);
    }
}
