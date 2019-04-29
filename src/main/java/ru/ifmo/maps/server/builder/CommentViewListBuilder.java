package ru.ifmo.maps.server.builder;

import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.dto.Comment;
import ru.ifmo.maps.server.models.CommentView;

import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentViewListBuilder {

    public List<CommentView> build(List<Comment> comments) {
        return comments.stream().map(this::buildCommentView).collect(Collectors.toList());
    }

    private CommentView buildCommentView(Comment comment) {
        CommentView commentView = new CommentView();
        commentView.setType(comment.getType());
        commentView.setDate(comment.getDate().atOffset(ZoneOffset.UTC));
        commentView.setName(comment.getName());
        commentView.setComment(comment.getText());
        return commentView;
    }
}
