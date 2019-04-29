package ru.ifmo.maps.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.ifmo.maps.server.api.CommentsApiDelegate;
import ru.ifmo.maps.server.logic.AddCommentOperation;
import ru.ifmo.maps.server.logic.GetCommentsOperation;
import ru.ifmo.maps.server.models.AddCommentView;
import ru.ifmo.maps.server.models.CommentView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentsController implements CommentsApiDelegate {

    private final AddCommentOperation addCommentOperation;
    private final GetCommentsOperation getCommentsOperation;

    @Override
    public ResponseEntity<Void> addComment(Long mapId,
                                           Integer floorNumber,
                                           Long x,
                                           Long y,
                                           AddCommentView commentView) {
        addCommentOperation.process(mapId, floorNumber, x, y, commentView);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<CommentView>> getComments(Long mapId,
                                                         Integer floorNumber,
                                                         Long x,
                                                         Long y) {
        List<CommentView> commentViews = getCommentsOperation.process(mapId, floorNumber, x, y);
        return ResponseEntity.ok(commentViews);
    }
}
