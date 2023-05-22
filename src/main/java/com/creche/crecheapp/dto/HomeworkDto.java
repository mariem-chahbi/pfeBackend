package com.creche.crecheapp.dto;

import com.creche.crecheapp.model.Homework;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HomeworkDto {
    private Integer id;
    private String title;
    private String description;
    private String image;
    private String text;

    public static HomeworkDto fromEntity(Homework homework) {
        if (homework == null) {
            return null;
        }
        return HomeworkDto.builder()
                .id(homework.getId())
                .title(homework.getTitle())
                .description(homework.getDescription())
                .image(homework.getImage())
                .text(homework.getText())
                .build();
    }

    public static Homework toEntity(HomeworkDto homeworkDto) {
        if (homeworkDto == null) {
            return null;
        }
        Homework homework = new Homework();
        homework.setId(homeworkDto.getId());
        homework.setTitle(homeworkDto.getTitle());
        homework.setDescription(homeworkDto.getDescription());
        homework.setImage(homeworkDto.getImage());
        homework.setText(homeworkDto.getText());
        return homework;
    }
}





