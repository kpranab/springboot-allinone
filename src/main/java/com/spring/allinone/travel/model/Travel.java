package com.spring.allinone.travel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Travel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String userId;
	private String source;
	private String destination;
	public Travel(String userId, String source, String destination) {
		super();
		this.userId = userId;
		this.source = source;
		this.destination = destination;
	}

}
