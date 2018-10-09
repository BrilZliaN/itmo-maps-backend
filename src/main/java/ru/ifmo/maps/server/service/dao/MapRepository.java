package ru.ifmo.maps.server.service.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.maps.server.dto.Map;

import java.util.List;

public interface MapRepository extends CrudRepository<Map, Long> {

    List<Map> findAll();

}
