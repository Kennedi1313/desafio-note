package com.desafio.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.desafio.model.Note;
import com.desafio.repository.NoteRepository;

@Controller
@Scope(value = "session")
@Component(value = "noteController")
@ELBeanName(value = "noteController")
@Join(path = "/edit", to = "/edit-form.jsf")
public class NoteEditController {
	@Autowired
	private NoteRepository noteRepository;
	private Note note = new Note();
	private Integer noteId;
	
	public String edit() {
		
		
		noteRepository.save(note);
		note = new Note();
		return "/note-list.xhtml?faces-redirect=true";
	}
	
	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

}
