package ua.lomakin.note.note.Service;

import org.springframework.stereotype.Service;
import ua.lomakin.note.note.Dto.Converter;
import ua.lomakin.note.note.Dto.NoteDto;
import ua.lomakin.note.note.Entity.NoteEntity;
import ua.lomakin.note.note.Entity.Repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final Converter converter;

    public NoteService(NoteRepository noteRepository, Converter converter) {
        this.noteRepository = noteRepository;
        this.converter = converter;
    }

    public List<NoteDto> getAllNotes(){
        List<NoteEntity> allNoteEntity = noteRepository.findAll();

        List<NoteDto> noteDtos = new ArrayList<>();

        if(!allNoteEntity.isEmpty()){
            allNoteEntity.forEach(noteEntity -> {
                NoteDto noteDto = converter.convertEntityToDto(noteEntity);
                noteDtos.add(noteDto);
            });
        }

        return noteDtos;
    }

    public List<NoteDto> createNote(NoteDto noteDto){

        NoteEntity noteEntity = converter.convertDtoToEntity(noteDto);
        noteRepository.save(noteEntity);
        return getAllNotes();

    }

    public List<NoteDto> deleteNote(Long id){

        NoteEntity noteEntity = noteRepository.getReferenceById(id);
        noteRepository.delete(noteEntity);
        return getAllNotes();

    }


}
