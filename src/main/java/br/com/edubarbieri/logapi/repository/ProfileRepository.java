package br.com.edubarbieri.logapi.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.edubarbieri.logapi.model.Profile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {
	Mono<Profile> findByOcId(String ocId);
	Flux<Profile> findByEmail(String email);
	Flux<Profile> findByLegalDocument(String legalDocument);
}
