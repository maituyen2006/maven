package com.team5solution.Controllers;

import com.team5solution.Facades.AccountFacade;
import com.team5solution.Entities.Account;
import com.team5solution.Responses.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Account/List")
public class AccountController {

    @GetMapping
    public ResponseApi List() {
        List list = new AccountFacade().list();
        return new ResponseApi().createSuccessResponse(list);
    }

    @GetMapping(value = "Active")
    public ResponseApi Active() {
        List list = new AccountFacade().active();
        return new ResponseApi().createSuccessResponse(list);
    }


    @GetMapping(value = "Role/{id}")
    public ResponseApi GetRole(@PathVariable(value = "id") String id) {
        boolean list = new AccountFacade().isAdmin(id);
        return new ResponseApi().createSuccessResponse(list);
    }

    @GetMapping(value = "{id}")
    public ResponseApi GetById(@PathVariable(value = "id") String id) {
        ResponseApi api = new ResponseApi();
        Account account;
        try {
            account = new AccountFacade().getAccountById(id);
            api.setMessage("Get object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
            api.setData(account);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @GetMapping(value = "Json/{id}")
    public ResponseApi GetCartJson(@PathVariable(name = "id") String id) {
        ResponseApi api = new ResponseApi();
        String account;
        try {
            account = new AccountFacade().getAccountCartJsonById(id);
            api.setMessage("Get cart json successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
            api.setData(account);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }


//    @GetMapping(value = "login")
//    public ResponseApi Login(@RequestBody Account account){
//
//    }

    @PostMapping
    public ResponseApi PostAccount(@RequestBody Account account) {
        ResponseApi api = new ResponseApi();
        try {
            Account acc = new AccountFacade().create(account);
            if (acc != null) {
                api.setMessage("Post object successful!");
                api.setSuccess(Boolean.TRUE);
                api.setCode(1);
                api.setData(account);
            } else {
                api.setMessage("Object is already exist!");
                api.setSuccess(Boolean.FALSE);
                api.setCode(0);
                api.setData(account);
            }
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @PutMapping
    public ResponseApi PutAccount(@RequestBody Account account) {
        ResponseApi api = new ResponseApi();
        try {
            new AccountFacade().update(account);
            api.setMessage("Put object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
            api.setData(account);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @DeleteMapping(value = "Block/{id}")
    public ResponseApi BlockAccount(@PathVariable("id") String id) {
        ResponseApi api = new ResponseApi();
        try {
            new AccountFacade().block(id);
            api.setMessage("Block object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }

    @DeleteMapping("/Unlock/{id}")
    public ResponseApi UnlockAccount(@PathVariable(name = "id") String id) {

        ResponseApi api = new ResponseApi();
        try {
            new AccountFacade().unlock(id);
            api.setMessage("Unlock object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }


    @DeleteMapping("{id}")
    public ResponseApi DeleteAccount(@PathVariable(value = "id") String id) {
        ResponseApi api = new ResponseApi();
        try {
            new AccountFacade().delete(id);
            api.setMessage("Delete object successful!");
            api.setSuccess(Boolean.TRUE);
            api.setCode(1);
        } catch (Exception ex) {
            api.setMessage(ex.getMessage());
        }
        return api;
    }
}
