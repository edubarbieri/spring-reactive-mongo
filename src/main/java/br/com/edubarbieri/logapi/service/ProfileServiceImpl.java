package br.com.edubarbieri.logapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edubarbieri.logapi.model.Profile;
import br.com.edubarbieri.logapi.repository.ProfileRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public Mono<Profile> createUser(Profile user) {
		return profileRepository.insert(user);
	}

	@Override
	public Mono<Profile> updateUser(Profile user, String id) {
		return findOne(id).doOnSuccess(findUser -> {
			findUser.setFirstName(user.getFirstName());
			findUser.setLastName(user.getLastName());
			profileRepository.save(findUser).subscribe();
		});
	}

	@Override
	public Mono<Profile> findOne(String id) {
		return profileRepository.findById(id)
				.switchIfEmpty(Mono.error(new Exception("No user found with Id: " + id)));
	}

	@Override
	public Flux<Profile> findByEmail(String email) {
		return profileRepository.findByEmail(email)
				.switchIfEmpty(Mono.error(new Exception("No user found with email: " + email)));
	}

	@Override
	public Flux<Profile> findByLegalDocument(String legalDocument) {
		return profileRepository.findByLegalDocument(legalDocument)
				.switchIfEmpty(Mono.error(new Exception("No user found with legalDocument: " + legalDocument)));
	}

}
