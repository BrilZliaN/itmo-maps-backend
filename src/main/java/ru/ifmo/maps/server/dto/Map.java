package ru.ifmo.maps.server.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime updated;

    @OneToMany
    @JoinColumn(name = "map_id")
    private List<Floor> floors;

    @OneToMany
    @JoinColumn(name = "map_id")
    private List<MapObject> mapObjects;

}
