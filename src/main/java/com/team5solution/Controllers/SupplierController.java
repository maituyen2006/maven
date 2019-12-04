package com.team5solution.Controllers;

import com.team5solution.Facades.SupplierFacade;
import com.team5solution.Entities.Supplier;
import com.team5solution.Responses.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Supplier/List")
public class SupplierController {

    @GetMapping
    public ResponseApi List() {
        List list = new SupplierFacade().list();
        return new ResponseApi().createSuccessResponse(list);
    }

    @GetMapping(value = "{id}")
    public ResponseApi GetById(@PathVariable(name = "id") String id) {
        ResponseApi api = new ResponseApi();

        try {
            api.setData(new SupplierFacade().find(id));
            api.setMessage("Get object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PostMapping
    public ResponseApi PostSupplier(@RequestBody Supplier supplier) {
        ResponseApi api = new ResponseApi();
        SupplierFacade dto = new SupplierFacade();
        try {
            dto.create(supplier);
            api.setMessage("Post object successful!");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
            api.setData(supplier);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @DeleteMapping(value = "{id}")
    public ResponseApi PostSupplier(@PathVariable(name = "id") String id) {
        ResponseApi api = new ResponseApi();
        SupplierFacade dto = new SupplierFacade();
        try {
            dto.delete(id);
            api.setMessage("Delete object successful!");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PutMapping
    public ResponseApi PutSupplier(@RequestBody Supplier supplier) {
        ResponseApi api = new ResponseApi();
        SupplierFacade dto = new SupplierFacade();
        try {
            dto.update(supplier);
            api.setMessage("Put object successful!");
            api.setCode(1);
            api.setSuccess(Boolean.TRUE);
            api.setData(supplier);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

}
