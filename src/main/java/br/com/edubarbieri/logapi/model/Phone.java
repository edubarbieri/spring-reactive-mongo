package br.com.edubarbieri.logapi.model;

import lombok.Data;

public @Data class Phone extends BaseEntity {
	private String id;
	private String ddd;
	private String ddi;
	private String number;
}
