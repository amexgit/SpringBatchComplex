package com.cts.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Data
@NoArgsConstructor
public class Employee implements Serializable{
	
	private static final long serialVersionUID = -1348385758217803698L;

	@Id
	private Long employeeId;
	
	private Long managerId;
	
	@NonNull
	private String name;
	
	@NonNull
	private String phoneNumber;
		
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "manager_id")
	private Employee manager;
	
}
