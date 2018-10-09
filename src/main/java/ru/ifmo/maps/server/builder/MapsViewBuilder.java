package ru.ifmo.maps.server.builder;

import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.dto.Map;
import ru.ifmo.maps.server.models.MapCompactView;
import ru.ifmo.maps.server.models.MapsView;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapsViewBuilder {

    public MapsView build(List<Map> maps) {
        MapsView mapsView = new MapsView();
        mapsView.setMaps(maps.stream().map(this::buildMapCompactView).collect(Collectors.toList()));
        mapsView.setUpdated(buildUpdated(maps));
        return mapsView;
    }

    private MapCompactView buildMapCompactView(Map map) {
        MapCompactView mapCompactView = new MapCompactView();
        mapCompactView.setId(map.getId());
        mapCompactView.setName(map.getName());
        return mapCompactView;
    }

    private OffsetDateTime buildUpdated(List<Map> maps) {
        return maps.stream()
                .map(Map::getUpdated)
                .max(LocalDateTime::compareTo)
                .orElse(LocalDateTime.MIN)
                .atOffset(ZoneOffset.UTC);
    }
}
