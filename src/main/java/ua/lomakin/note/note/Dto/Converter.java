package ua.lomakin.note.note.Dto;

import org.springframework.stereotype.Service;
import ua.lomakin.note.note.Entity.NoteEntity;

@Service
public class Converter {

    public NoteDto convertEntityToDto(NoteEntity noteEntity){

        return NoteDto.builder()
                .id(noteEntity.getId())
                .name(noteEntity.getName())
                .text(noteEntity.getText())
                .grand(noteEntity.getGrand())
                .build();
    }

    public NoteEntity convertDtoToEntity(NoteDto noteDto){

        return NoteEntity.builder()
                .name(noteDto.getName())
                .text(noteDto.getText())
                .grand(noteDto.getGrand())
                .build();
    }

}
