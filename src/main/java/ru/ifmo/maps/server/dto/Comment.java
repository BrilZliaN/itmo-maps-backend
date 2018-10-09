package ru.ifmo.maps.server.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "map_id", referencedColumnName = "id")
    private Map map;

    @ManyToOne
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    private Floor floor;

    private Long x;

    private Long y;

    private LocalDateTime date;

    private String type;

    private String name;

    private String text;
}
