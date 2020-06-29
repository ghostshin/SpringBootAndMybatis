package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enity.Note;
import com.example.demo.mapper.NoteMapper;

@Service
public class NoteServiceImpl implements NoteService {

	
	 @Autowired
	 
	 NoteMapper noteMapper;
	 
	@Override
	public Integer insert(Note note) {
		// TODO Auto-generated method stub
		return noteMapper.insert(note);
	}

}
