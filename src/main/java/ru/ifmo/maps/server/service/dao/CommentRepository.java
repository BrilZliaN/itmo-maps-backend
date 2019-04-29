package ru.ifmo.maps.server.service.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.ifmo.maps.server.dto.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c " +
            "WHERE c.map.id = :mapId AND c.floor.number = :floorNumber " +
            "AND c.x = :x AND c.y = :y AND c.deleted = false")
    List<Comment> findAllByMapIdAndCoordinates(@Param("mapId") Long mapId,
                                               @Param("floorNumber") Integer floorNumber,
                                               @Param("x") Long x,
                                               @Param("y") Long y);

}
