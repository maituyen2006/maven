package com.team5solution.Controllers;


import com.team5solution.Facades.CategoryFacade;
import com.team5solution.Entities.Category;
import com.team5solution.Responses.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Category/List")
public class CategoryController {

    @GetMapping
    public ResponseApi list() {
        List list = new CategoryFacade().list();
        return new ResponseApi().createSuccessResponse(list);
    }

    @GetMapping(value = "Available")
    public ResponseApi Available() {
        List list = new CategoryFacade().available();
        return new ResponseApi().createSuccessResponse(list);
    }

    @GetMapping(value = "{id}/Product")
    public ResponseApi GetListProductByCategoryId(@PathVariable(value = "id") String id) {
        ResponseApi api = new ResponseApi();
        CategoryFacade cFacade = new CategoryFacade();
        try {
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
            api.setData(cFacade.productsByCategoryId(id));
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }


    @GetMapping(value = "{id}")
    public ResponseApi GetById(@PathVariable(value = "id") String id) {
        ResponseApi api = new ResponseApi();
        CategoryFacade cFacade = new CategoryFacade();
        try {
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
            api.setData(cFacade.find(id));
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PostMapping
    public ResponseApi PostCategory(@RequestBody Category category) {
        ResponseApi api = new ResponseApi();
        try {
            new CategoryFacade().create(category);
            api.setMessage("Post object successful!");
            api.setData(category);
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PutMapping
    public ResponseApi PutCategory(@RequestBody Category category) {
        ResponseApi api = new ResponseApi();
        CategoryFacade cFacade = new CategoryFacade();
        try {
            new CategoryFacade().update(category);
            api.setMessage("Post object successful!");
            api.setData(category);
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @DeleteMapping("{id}")
    public ResponseApi DeleteCategory(@PathVariable(value = "id") String id) {
        ResponseApi api = new ResponseApi();
        try {
            new CategoryFacade().delete(id);
            api.setMessage("Delete object successful!");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

}
