package ua.lomakin.note.note.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lomakin.note.note.Dto.NoteDto;
import ua.lomakin.note.note.Service.NoteService;

import java.util.List;

@Controller
@RequestMapping("/add")
public class AddNoteController {

    private final NoteService noteService;

    public AddNoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("")
    public String addNote(){
        return "add_note";
    }

    @PostMapping("")
    public String newNote(Model model,
                          @RequestParam("name") String name,
                          @RequestParam("text") String text,
                          @RequestParam(value = "grand",
                                        required = false,
                                        defaultValue = "false") Boolean grand){

        NoteDto noteDto = NoteDto.builder()
                .name(name)
                .text(text)
                .grand(grand)
                .build();

        noteService.createNote(noteDto);
        List<NoteDto> allNotes = noteService.getAllNotes();
        model.addAttribute("notes", allNotes);

        return "redirect:/";
    }
}
