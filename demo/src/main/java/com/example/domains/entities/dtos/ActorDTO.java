package com.example.domains.entities.dtos;

import com.example.domains.entities.Actor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ActorDTO {
	private int actorId;
	@NotBlank
	@Size(max = 45, min=2)
	@Pattern(regexp = "^[A-Z]+$", message = "debe estar en mayúsculas")
	private String firstName;
	@NotBlank
	@Size(max = 45, min=2)
	private String lastName;

	public static ActorDTO from(Actor source) {
		return new ActorDTO(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}

	public static Actor from(ActorDTO source) {
		return new Actor(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
}
