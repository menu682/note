package ua.lomakin.note.note.Controller;


import org.springframework.web.bind.annotation.*;
import ua.lomakin.note.note.Dto.NoteDto;
import ua.lomakin.note.note.Service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("")
    public List<NoteDto> getAllNotes(){
        return noteService.getAllNotes();
    }

    @PostMapping("")
    public List<NoteDto> createNote(
            @RequestBody NoteDto noteDto
    ){
        return noteService.createNote(noteDto);
    }

    @DeleteMapping("/{id}")
    public List<NoteDto> deleteNote(@PathVariable Long id){
        return noteService.deleteNote(id);
    }

}
