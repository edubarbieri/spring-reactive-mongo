package br.com.edubarbieri.logapi.service;

import br.com.edubarbieri.logapi.model.Profile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileService {
	Mono<Profile> createUser(Profile user);
	Mono<Profile> updateUser(Profile user, String id);
	Mono<Profile> findOne(String id);
	Flux<Profile> findByEmail(String email);
	Flux<Profile> findByLegalDocument(String legalDocument);
}
