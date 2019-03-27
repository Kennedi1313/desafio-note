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
@Scope(value = "session")
// nome do controlador dentro do contexto da aplicação
@Component(value = "noteList")
@ELBeanName(value = "noteList")
// caminho que este controlador responde e a pagina que renderiza (utilizando URL Rewrite)
@Join(path = "/", to = "/note-list.jsf")
public class NoteListController {
	@Autowired
	private NoteRepository noteRepository;
	private List<Note> notes;

	// recupera a nota em questão do banco para ser exibida na tela
	// as anotações são utilizadas para que o metodo seja executado antes da pagina
	// ser renderizada
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
