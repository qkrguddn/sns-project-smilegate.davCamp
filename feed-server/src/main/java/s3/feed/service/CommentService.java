package s3.feed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s3.feed.entity.*;
import s3.feed.exception.ForbiddenException;
import s3.feed.repository.CommentRepository;
import s3.feed.repository.PostRepository;
import s3.feed.repository.ReplyRepository;
import s3.feed.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ReplyRepository replyRepository;
    public ResponseEntity createComment(String accountId, Long postId, String comment){
        UserEntity userEntity = userRepository.findByAccountId(accountId);
        CommentEntity cmtEntity = commentRepository.findByAccountId(accountId);
        CommentEntity commentEntity = new CommentEntity(comment, accountId, LocalDateTime.now(), 0, userEntity.getProfileImage());
        PostEntity postEntity = postRepository.findById(postId).get();
        postEntity.upCommentCount(postEntity.getCommentCount());
        postEntity.getCommentEntityList().add(commentEntity);
        postRepository.save(postEntity);
        return ResponseEntity.ok("댓글 등록");
    }

    public ResponseEntity deleteComment(String accountId, Long commentId){
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        String commentWriter = commentEntity.getAccountId();
        if(commentWriter.equals(accountId)) {
            commentRepository.deleteById(commentId);
        }
        else
            throw new ForbiddenException("권한이 없습니다.");
        return ResponseEntity.ok("댓글 삭제 성공");
    }
    public ResponseEntity createReplies(String accountId, Long commentId, String reply){
        UserEntity userEntity = userRepository.findByAccountId(accountId);
        ReplyEntity replyEntity = new ReplyEntity(reply, accountId, LocalDateTime.now(), 0, userEntity.getProfileImage());
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        commentEntity.getReplyEntityList().add(replyEntity);
        commentRepository.save(commentEntity);
        return ResponseEntity.ok("대댓글 등록");

    }

    public ResponseEntity deleteReply(String accountId, Long replyId){
        ReplyEntity replyEntity = replyRepository.findById(replyId).get();
        String replyWriter = replyEntity.getAccountId();
        if(replyWriter.equals(accountId)) {
            replyRepository.deleteById(replyId);
        }
        else
            throw new ForbiddenException("권한이 없습니다.");
        return ResponseEntity.ok("대댓글 삭제 성공");
    }

}
