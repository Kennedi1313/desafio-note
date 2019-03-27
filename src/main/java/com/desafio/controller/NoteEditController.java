package com.desafio.controller;

import java.util.Optional;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desafio.model.Note;
import com.desafio.repository.NoteRepository;

@Controller
@Scope(value = "session")
//nome do controlador dentro do contexto da aplicação
@Component(value = "noteEdit")
@ELBeanName(value = "noteEdit")
//caminho que este controlador responde e a pagina que renderiza (utilizando URL Rewrite)
@Join(path = "/edit/{id}", to = "/edit-form.jsf")
public class NoteEditController {
	@Autowired
	private NoteRepository noteRepository;
	private Note note;
	private Integer noteId;

	// atualiza no banco a nota existente na variável note
	public String save() {
		noteRepository.save(note);
		return "/note-list.xhtml?faces-redirect=true";
	}

	// recupera a nota em questão do banco para ser exibida na tela (e
	// posteriormente editada)
	// as anotações são utilizadas para que o metodo seja executado antes da pagina
	// ser renderizada
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		// recupera o id que foi enviado pela url
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		noteId = Integer.parseInt(id);
		Optional<Note> noteaux = noteRepository.findById(noteId);
		if (noteaux.isPresent())
			note = noteaux.get();
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
