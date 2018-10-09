package ru.ifmo.maps.server.service.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.ifmo.maps.server.dto.Floor;

import java.util.Optional;

public interface FloorRepository extends CrudRepository<Floor, Long> {

    @Query("SELECT f FROM Floor f WHERE f.map.id = :mapId AND f.number = :floorNumber")
    Optional<Floor> findByMapIdAndNumber(@Param("mapId") Long mapId, @Param("floorNumber") Integer floorNumber);
}
