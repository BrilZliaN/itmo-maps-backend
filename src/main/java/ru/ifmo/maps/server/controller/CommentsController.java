package ru.ifmo.maps.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.ifmo.maps.server.api.CommentsApiDelegate;
import ru.ifmo.maps.server.models.AddCommentView;
import ru.ifmo.maps.server.models.CommentView;

import java.util.List;

@Controller
public class CommentsController implements CommentsApiDelegate {

    @Override
    public ResponseEntity<Void> addComment(Long mapId,
                                           Integer floorNumber,
                                           Long x,
                                           Long y) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<CommentView>> getComments(Long mapId,
                                                         Integer floorNumber,
                                                         Long x,
                                                         Long y,
                                                         AddCommentView commentView) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
