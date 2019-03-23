package com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafio.model.Note;
import com.desafio.repository.NoteRepository;

@Controller
@RequestMapping("/")
public class NoteController {
	@Autowired
	private NoteRepository noteRepository;

	@GetMapping("/create")
	public String cadastro(Model model) {
		return "/create";
	}

	@GetMapping("/index")
	public String index() {
		return "/index";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("note") Note note) {
		noteRepository.save(note);
		return "redirect:/listar";
	}

	@GetMapping("/listar")
	public String index(Model model) {
		List<Note> listaNotes = noteRepository.findAll();
		if (listaNotes != null) {
			model.addAttribute("notes", listaNotes);
		}
		return "/index";
	}

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

}
