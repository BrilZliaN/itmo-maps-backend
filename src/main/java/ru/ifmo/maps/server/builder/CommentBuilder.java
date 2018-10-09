package ru.ifmo.maps.server.builder;

import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.dto.Comment;
import ru.ifmo.maps.server.dto.Floor;
import ru.ifmo.maps.server.models.AddCommentView;

@Component
public class CommentBuilder {

    public Comment build(Floor floor,
                         Long x,
                         Long y,
                         AddCommentView commentView) {
        Comment comment = new Comment();
        comment.setMap(floor.getMap());
        comment.setFloor(floor);
        comment.setX(x);
        comment.setY(y);
        comment.setType(commentView.getType());
        comment.setName(commentView.getName());
        comment.setText(commentView.getComment());
        return comment;
    }
}
