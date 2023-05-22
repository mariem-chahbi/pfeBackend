package com.creche.crecheapp.dto;

import com.creche.crecheapp.model.Reclamation;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReclamationDto {
    private Integer id;
    private String title ;
    private String text ;

    public ReclamationDto() {
    }

    public ReclamationDto(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
    public static ReclamationDto fromEntity(Reclamation reclamation) {
        if (reclamation == null) {
            return null;
        }
       return ReclamationDto.builder()
               .id(reclamation.getId())
               .title(reclamation.getTitle())
               .text(reclamation.getText())
               .build();


               }

public static Reclamation toEntity(ReclamationDto  reclamationDto) {
        if (reclamationDto == null) {
        return null;
        }

        Reclamation reclamation = new Reclamation();
        reclamation.setId(reclamationDto.getId());
        reclamation.setTitle(reclamationDto.getTitle());
        reclamation.setText(reclamationDto.getText());
        return reclamation;


        }
}
