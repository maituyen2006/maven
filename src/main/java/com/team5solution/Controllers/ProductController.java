package com.team5solution.Controllers;


import com.team5solution.Facades.ProductFacade;
import com.team5solution.Entities.Product;
import com.team5solution.Responses.ResponseApi;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "Product/List")
public class ProductController {

    @GetMapping
    public ResponseApi list() {
        List list = new ProductFacade().list();
        return new ResponseApi().createSuccessResponse(list);
    }

    //
    @GetMapping(value = "{id}")
    public ResponseApi getById(@PathVariable(name = "id") String id) {
        List list = new ProductFacade().find(id);
        return new ResponseApi().createSuccessResponse(list);
    }


    @GetMapping(value = "Available")
    public ResponseApi Available() {
        List list = new ProductFacade().Available();
        return new ResponseApi().createSuccessResponse(list);
    }

    @GetMapping(value = "?Search={name}")
    public ResponseApi GetByName(@PathVariable(name = "name") String name) {
        List list = new ProductFacade().findByName(name);
        return new ResponseApi().createSuccessResponse(list);
    }

    @PostMapping
    public ResponseApi PostProduct(@RequestBody Product product) {
        ResponseApi api = new ResponseApi();
        try {

            new ProductFacade().create(product);
            api.setMessage("Create object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
            api.setData(product);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PutMapping
    public ResponseApi PutProduct(@RequestBody Product product) {
        ProductFacade dto = new ProductFacade();
        ResponseApi api = new ResponseApi();
        try {
            dto.update(product);
            api.setMessage("Update object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @DeleteMapping(value = "{id}")
    public ResponseApi DeleteProduct(@PathVariable String id) {
        ResponseApi api = new ResponseApi();
        try {
            new ProductFacade().delete(id);
            api.setMessage("Delete object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

}
