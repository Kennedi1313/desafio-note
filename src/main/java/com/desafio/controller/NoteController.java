package com.desafio.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desafio.model.Note;
import com.desafio.repository.NoteRepository;

@Controller
@Scope(value = "session")
@Component(value = "noteController")
@ELBeanName(value = "noteController")
@Join(path = "/create", to = "/create-form.jsf")
public class NoteController {
	@Autowired
	private NoteRepository noteRepository;
	private Note note = new Note();
	
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

	
	/* FAZER ISSO DEPOIS
	@GetMapping("editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		// Note note = noteRepository.findById(id);
		// model.addAttribute("note", note);
		return "/edit";
	}

	@GetMapping("deletar/{id}")
	public String deletar(@PathVariable Integer id, Model model) {
		// Note note = noteRepository.findById(id);
		// noteRepository.delete(note);
		return "redirect:/listar";
	}

	@PostMapping("atualizar/{id}")
	public String atualizar(@PathVariable Integer id, Note note) {
		note.setId(id);
		noteRepository.save(note);
		return "redirect:/listar";
	}
	
	*/

}
