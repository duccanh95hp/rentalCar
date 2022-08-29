package com.example.rentalcar.controller;

import com.example.rentalcar.dto.listSb;
import com.example.rentalcar.model.SubscribersEntity;
import com.example.rentalcar.service.subscribersService;
import com.example.rentalcar.service.subscribersServiceIpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/admin/subscribers")
public class subscribersController {

    @Autowired
    subscribersService subscribersService;
    //thêm
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<SubscribersEntity> addSb(@RequestBody SubscribersEntity sb){
        subscribersService.saveSubscribers(sb);
        return ResponseEntity.ok(sb);
    }
    //get all
    @RequestMapping(value = "/lists",method = RequestMethod.GET)
    public ResponseEntity<List<SubscribersEntity>> listsSb(){
        List<SubscribersEntity> listSb = subscribersService.listsSubscribers();
        if(listSb.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<List<SubscribersEntity>>(listSb,HttpStatus.OK);
        }
    }
    //update
    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<SubscribersEntity> updateSb(@PathVariable("id") Long id,
                                                      @RequestBody SubscribersEntity sb){
        SubscribersEntity oldSb = subscribersService.findSbById(id);
        if(oldSb == null){
            return ResponseEntity.notFound().build();
        }else {
            oldSb.setSubscribersemail(sb.getSubscribersemail());
            subscribersService.saveSubscribers(oldSb);
            return ResponseEntity.ok(sb);
        }
    }
    //xóa
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ResponseEntity<SubscribersEntity> deleteSb(@PathVariable("id") Long id){
        SubscribersEntity oldSb = subscribersService.findSbById(id);
        if(oldSb == null){
            return ResponseEntity.notFound().build();
        }else {
            subscribersService.deleteSb(id);
            return ResponseEntity.ok(oldSb);
        }
    }
    //nơi trả về dữ liệu cho view
    @RequestMapping(value = "/listSb",method = RequestMethod.GET)
    public ResponseEntity<listSb> listsListMarks(){
        List<SubscribersEntity> lists = subscribersService.listsSubscribers();
        listSb lss = new listSb();
        lss.setData(lists);

        return new ResponseEntity<listSb>(lss,HttpStatus.OK);
    }
    //trả về kết quả validate
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName()  + " "
                    + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
