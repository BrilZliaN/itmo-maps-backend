package ru.ifmo.maps.server.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.models.MapsView;
import ru.ifmo.maps.server.service.dao.MapDaoAdapter;

@Component
@RequiredArgsConstructor
public class GetMapsOperation {

    private final MapDaoAdapter mapDaoAdapter;

    public MapsView process() {
        return mapDaoAdapter.getMaps();
    }
}
