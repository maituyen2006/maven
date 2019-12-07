package com.team5solution.Controllers;

import com.team5solution.Entities.Comment;
import com.team5solution.Facades.CommentFacade;
import com.team5solution.Responses.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Product/Comment")
public class CommentController {

    @GetMapping
    public ResponseApi List() {
        List list = new CommentFacade().list();
        return new ResponseApi().createSuccessResponse(list);
    }

    @GetMapping(value = "{id}")
    public ResponseApi GetCommentsByProduct(@PathVariable(value = "id") String id) {
        ResponseApi api = new ResponseApi();
        CommentFacade commentFacade = new CommentFacade();
        try {
            api.setMessage("Get List Successful");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
            api.setData(commentFacade.commentsByProduct(id));
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PostMapping
    public ResponseApi AddComment(@RequestBody Comment comment) {
        ResponseApi api = new ResponseApi();
        CommentFacade commentFacade = new CommentFacade();
        try {
            api.setMessage("Post object Successful");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
            api.setData(commentFacade.create(comment));
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @DeleteMapping(value = "{id}")
    public ResponseApi AddComment(@PathVariable(value = "id") String id) {
        ResponseApi api = new ResponseApi();
        CommentFacade commentFacade = new CommentFacade();
        try {
            api.setMessage("Delete object Successful");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
            commentFacade.delete(id);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }


}
