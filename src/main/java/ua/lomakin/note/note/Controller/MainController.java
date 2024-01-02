package ua.lomakin.note.note.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lomakin.note.note.Dto.NoteDto;
import ua.lomakin.note.note.Service.NoteService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final NoteService noteService;

    public MainController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public String getMain(Model model){

        List<NoteDto> allNotes = noteService.getAllNotes();
        model.addAttribute("notes", allNotes);

        return "main";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id, Model model){

        noteService.deleteNote(id);
        List<NoteDto> allNotes = noteService.getAllNotes();
        model.addAttribute("notes", allNotes);

        return "redirect:/";
    }


}
