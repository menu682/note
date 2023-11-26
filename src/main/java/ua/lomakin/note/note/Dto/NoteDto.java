package ua.lomakin.note.note.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NoteDto {

    private Long id;
    private String name;
    private String text;
    private Boolean grand;

}
