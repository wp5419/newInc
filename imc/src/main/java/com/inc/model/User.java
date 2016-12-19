package com.inc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5493003124427301181L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	
	private String password;
}
