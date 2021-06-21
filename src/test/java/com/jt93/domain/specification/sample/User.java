package com.jt93.domain.specification.sample;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	private String	name;
	private String	firstname;
	private Date	birthDate;
	private boolean	enabled;

}
