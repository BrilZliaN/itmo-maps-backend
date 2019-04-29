package ru.ifmo.maps.server.service.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.builder.MapViewBuilder;
import ru.ifmo.maps.server.builder.MapsViewBuilder;
import ru.ifmo.maps.server.dto.Map;
import ru.ifmo.maps.server.exception.ExceptionFactory;
import ru.ifmo.maps.server.models.MapView;
import ru.ifmo.maps.server.models.MapsView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapDaoAdapter {

    private final MapRepository mapRepository;
    private final MapsViewBuilder mapsViewBuilder;
    private final MapViewBuilder mapViewBuilder;

    public MapsView getMaps() {
        List<Map> maps;
        try {
            maps = mapRepository.findAll();
        } catch (DataAccessException exception) {
            throw ExceptionFactory.wrap(exception);
        }
        return mapsViewBuilder.build(maps);
    }

    public MapView getMap(Long id) {
        Map map;
        try {
            map = mapRepository.findById(id).orElseThrow(ExceptionFactory::notFound);
        } catch (DataAccessException exception) {
            throw ExceptionFactory.wrap(exception);
        }
        return mapViewBuilder.build(map);
    }
}
