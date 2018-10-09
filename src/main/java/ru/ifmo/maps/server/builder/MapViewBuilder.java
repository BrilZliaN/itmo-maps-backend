package ru.ifmo.maps.server.builder;

import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.dto.Floor;
import ru.ifmo.maps.server.dto.Map;
import ru.ifmo.maps.server.dto.MapObject;
import ru.ifmo.maps.server.models.CoordinatesView;
import ru.ifmo.maps.server.models.MapObjectView;
import ru.ifmo.maps.server.models.MapView;
import ru.ifmo.maps.server.models.PictureView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapViewBuilder {

    public MapView build(Map map) {
        MapView mapView = new MapView();
        mapView.setName(map.getName());
        List<MapObjectView> objectViews = map.getMapObjects().stream().map(this::buildMapObjectView).collect(Collectors.toList());
        mapView.setObjects(objectViews);
        List<PictureView> pictureViews = map.getFloors().stream().map(this::buildPictureView).collect(Collectors.toList());
        mapView.setPictures(pictureViews);
        return mapView;
    }

    private PictureView buildPictureView(Floor floor) {
        PictureView pictureView = new PictureView();
        pictureView.setFloor(floor.getNumber());
        pictureView.setUrl(floor.getPictureUrl());
        return pictureView;
    }

    private MapObjectView buildMapObjectView(MapObject mapObject) {
        MapObjectView mapObjectView = new MapObjectView();
        mapObjectView.setCoordinates(buildCoordinatesView(mapObject));
        mapObjectView.setName(mapObject.getName());
        mapObjectView.setDescription(mapObject.getDescription());
        mapObjectView.setType(mapObject.getType());
        return mapObjectView;
    }

    private CoordinatesView buildCoordinatesView(MapObject mapObject) {
        CoordinatesView coordinatesView = new CoordinatesView();
        coordinatesView.setX(mapObject.getX());
        coordinatesView.setY(mapObject.getY());
        coordinatesView.setFloor(mapObject.getFloor().getNumber());
        return coordinatesView;
    }
}
