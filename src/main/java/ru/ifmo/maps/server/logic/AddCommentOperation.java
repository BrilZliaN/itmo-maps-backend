package ru.ifmo.maps.server.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.models.AddCommentView;
import ru.ifmo.maps.server.service.dao.CommentDaoAdapter;

@Component
@RequiredArgsConstructor
public class AddCommentOperation {

    private final CommentDaoAdapter commentDaoAdapter;

    public void process(Long mapId,
                        Integer floorNumber,
                        Long x,
                        Long y,
                        AddCommentView commentView) {
        commentDaoAdapter.addComment(mapId, floorNumber, x, y, commentView);
    }
}
