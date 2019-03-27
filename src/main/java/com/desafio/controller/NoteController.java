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
//nome do controlador dentro do contexto da aplicação
@Component(value = "noteController")
@ELBeanName(value = "noteController")
//caminho que este controlador responde e a pagina que renderiza (utilizando URL Rewrite)
@Join(path = "/create", to = "/create-form.jsf")
public class NoteController {
	@Autowired
	private NoteRepository noteRepository;
	private Note note = new Note();

	// cadastra no banco as informações salvas na variável note
	public String save() {
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

}
