package ru.ifmo.maps.server.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MapObject {

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

    private String type;

    private String name;

    private String description;


}
