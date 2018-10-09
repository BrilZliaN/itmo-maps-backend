package ru.ifmo.maps.server.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "map_id", referencedColumnName = "id")
    private Map map;

}
