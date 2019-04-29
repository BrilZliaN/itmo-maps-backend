package ru.ifmo.maps.server.service.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import ru.ifmo.maps.server.builder.CommentBuilder;
import ru.ifmo.maps.server.builder.CommentViewListBuilder;
import ru.ifmo.maps.server.dto.Comment;
import ru.ifmo.maps.server.dto.Floor;
import ru.ifmo.maps.server.exception.ExceptionFactory;
import ru.ifmo.maps.server.models.AddCommentView;
import ru.ifmo.maps.server.models.CommentView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentDaoAdapter {

    private final CommentRepository commentRepository;
    private final FloorRepository floorRepository;
    private final CommentViewListBuilder commentViewListBuilder;
    private final CommentBuilder commentBuilder;

    public List<CommentView> getComments(Long mapId,
                                         Integer floorNumber,
                                         Long x,
                                         Long y) {
        List<Comment> comments;
        try {
            comments = commentRepository.findAllByMapIdAndCoordinates(mapId, floorNumber, x, y);
        } catch (DataAccessException exception) {
            throw ExceptionFactory.wrap(exception);
        }
        return commentViewListBuilder.build(comments);
    }

    public void addComment(Long mapId,
                           Integer floorNumber,
                           Long x,
                           Long y,
                           AddCommentView commentView) {
        Floor floor;
        try {
            floor = floorRepository.findByMapIdAndNumber(mapId, floorNumber).orElseThrow(ExceptionFactory::notFound);
        } catch (DataAccessException exception) {
            throw ExceptionFactory.wrap(exception);
        }
        Comment comment = commentBuilder.build(floor, x, y, commentView);
        try {
            commentRepository.save(comment);
        } catch (DataAccessException exception) {
            throw ExceptionFactory.wrap(exception);
        }
    }

}
