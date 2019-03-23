package com.desafio.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

}
