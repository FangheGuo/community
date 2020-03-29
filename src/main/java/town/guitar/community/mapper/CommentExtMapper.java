package town.guitar.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import town.guitar.community.model.Comment;
import town.guitar.community.model.CommentExample;

import java.util.List;
@Component
public interface CommentExtMapper {

    int incCommentCount(Comment comment);
}