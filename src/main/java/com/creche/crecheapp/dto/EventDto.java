package com.creche.crecheapp.dto;

import com.creche.crecheapp.model.Event;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class EventDto {
    private Integer id;

    private String title;
    private Date date;
    private String description;

    public static EventDto fromEntity(Event event) {
        if (event == null) {
            return null;
        }
       return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .date(event.getDate())
                .description(event.getDescription())
                .build();


    }

    public static Event toEntity(EventDto  eventDto) {
        if (eventDto == null) {
            return null;
        }

        Event event = new Event();
        event.setId(eventDto.getId());
        event.setTitle(eventDto.getTitle());
        event.setDate(eventDto.getDate());
        event.setDescription(eventDto.getDescription());
        return event;


    }



}
