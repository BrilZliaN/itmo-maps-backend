package ru.ifmo.maps.server.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.models.MapView;
import ru.ifmo.maps.server.service.dao.MapDaoAdapter;

@Component
@RequiredArgsConstructor
public class GetMapOperation {

    private final MapDaoAdapter mapDaoAdapter;

    public MapView process(Long mapId) {
        return mapDaoAdapter.getMap(mapId);
    }
}
