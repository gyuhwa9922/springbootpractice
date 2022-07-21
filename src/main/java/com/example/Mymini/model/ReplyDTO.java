package com.example.Mymini.model;

import lombok.Data;

@Data
public class ReplyDTO {
	private int id;
	private int boardId;
	private int writerId;
	private String content;

	public boolean equals(Object o) {
		if (o instanceof ReplyDTO) {
			ReplyDTO r = (ReplyDTO) o;
			return id == r.id;
		}
		return false;
	}

}
