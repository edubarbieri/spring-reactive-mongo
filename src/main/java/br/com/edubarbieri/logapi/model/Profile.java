package br.com.edubarbieri.logapi.model;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "profile")
public @Data class Profile extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Indexed
	private String ocId;
	private String firstName;
	private String lastName;
	@Indexed
	private String legalDocument;
	@Indexed
	private String email;
	private List<Phone> phones;
}
