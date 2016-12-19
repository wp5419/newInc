package com.inc.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="localAuth")
public class LocalAuth implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1926846861245111980L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
	private User user;
	
	private String username;
	
	private String password;
}
