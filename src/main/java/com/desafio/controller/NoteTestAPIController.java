package com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.model.Note;
import com.desafio.repository.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteTestAPIController {
	@Autowired
	NoteRepository noteRepository;

	@GetMapping
	public ResponseEntity<List<Note>> listAPI() {
		return ResponseEntity.status(HttpStatus.OK).body(noteRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Note> createAPI(@RequestBody Note note) {
		
		try {
			noteRepository.save(note);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(note);
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(note);
			
		}
}
}
