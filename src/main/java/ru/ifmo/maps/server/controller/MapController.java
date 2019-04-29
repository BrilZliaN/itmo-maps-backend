package ru.ifmo.maps.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.ifmo.maps.server.api.MapApiDelegate;
import ru.ifmo.maps.server.logic.GetMapOperation;
import ru.ifmo.maps.server.logic.GetMapsOperation;
import ru.ifmo.maps.server.models.MapView;
import ru.ifmo.maps.server.models.MapsView;

@Controller
@RequiredArgsConstructor
public class MapController implements MapApiDelegate {

    private final GetMapOperation getMapOperation;
    private final GetMapsOperation getMapsOperation;

    @Override
    public ResponseEntity<MapView> getMap(Long mapId) {
        MapView view = getMapOperation.process(mapId);
        return ResponseEntity.ok(view);
    }

    @Override
    public ResponseEntity<MapsView> getMaps() {
        MapsView view = getMapsOperation.process();
        return ResponseEntity.ok(view);
    }

}
