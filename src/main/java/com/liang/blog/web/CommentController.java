package com.liang.blog.web;

import com.liang.blog.po.Comment;
import com.liang.blog.po.User;
import com.liang.blog.service.BlogService;
import com.liang.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    // @Value(value = "${avatar}")
    private String avatar = "https://i.picsum.photos/id/114/3264/2448.jpg?hmac=DOmBAsmlq14qncJF_8kOc4zPjtJtVBqmymXphtNHPOA";

    @Transactional
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> commentList = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", commentList);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        comment.setAvatar(avatar);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}