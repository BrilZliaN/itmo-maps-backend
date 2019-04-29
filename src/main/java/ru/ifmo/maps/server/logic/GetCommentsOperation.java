package ru.ifmo.maps.server.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.models.CommentView;
import ru.ifmo.maps.server.service.dao.CommentDaoAdapter;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCommentsOperation {

    private final CommentDaoAdapter commentDaoAdapter;

    public List<CommentView> process(Long mapId,
                                     Integer floorNumber,
                                     Long x,
                                     Long y) {
        return commentDaoAdapter.getComments(mapId, floorNumber, x, y);
    }
}
