package com.team5solution.Controllers;

import com.team5solution.Facades.SalesOrderFacade;
import com.team5solution.Entities.SalesOrder;
import com.team5solution.Responses.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/SO/List")//sales order = so
public class SalesOrderController {

    @GetMapping
    public ResponseApi List() {
        List list = new SalesOrderFacade().list();
        return new ResponseApi().createSuccessResponse(list);
    }


    @GetMapping("{id}")
    public ResponseApi GetById(@PathVariable(name = "id") String id) {
        ResponseApi api = new ResponseApi();
        SalesOrderFacade dto = new SalesOrderFacade();
        try {
            api.setData(dto.getDetailSalesOrderById(id));
            api.setMessage("Get object successful!");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PostMapping
    public ResponseApi PostSalesOrder(@RequestBody SalesOrder order) {
        ResponseApi api = new ResponseApi();
        try {
            new SalesOrderFacade().create(order);
            api.setMessage("Post object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
            api.setData(order);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PutMapping
    public ResponseApi PutSalesOrder(@RequestBody SalesOrder order) {
        ResponseApi api = new ResponseApi();
        try {
            new SalesOrderFacade().update(order);
            api.setMessage("Put object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
            api.setData(order);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @DeleteMapping("{id}")
    public ResponseApi DeleteSalesOrder(@PathVariable(name = "id") String id) {
        ResponseApi api = new ResponseApi();
        try {
            new SalesOrderFacade().delete(id);
            api.setMessage("Post object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }


}
