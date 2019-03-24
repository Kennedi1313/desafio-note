package com.desafio.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.desafio.model.Note;
import com.desafio.repository.NoteRepository;

@Controller
@Scope (value = "session")
@Component (value = "noteList")
@ELBeanName(value = "noteList")
@Join(path = "/", to = "/note-list.jsf")
public class NoteListController {
	@Autowired
	private NoteRepository noteRepository;
	private List<Note> notes;
	
	@Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        notes = noteRepository.findAll();
    }

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	
}
