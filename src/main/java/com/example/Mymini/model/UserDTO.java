package com.example.Mymini.model;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private String Username;
	private String password;
	private String Nickname;
	
	public boolean equals(Object o) {
		if (o instanceof UserDTO) {
			UserDTO u = (UserDTO) o;
			return id == u.id;
		}
		return false;
	}
	
}
