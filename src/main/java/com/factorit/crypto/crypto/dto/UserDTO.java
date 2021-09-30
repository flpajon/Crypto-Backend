package com.factorit.crypto.crypto.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDTO {
	
	@NonNull
	private String user;
	@NonNull
	private String name;
	@NonNull
	private String surname;
}
