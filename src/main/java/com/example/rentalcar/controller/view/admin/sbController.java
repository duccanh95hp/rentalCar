package com.example.rentalcar.controller.view.admin;

import com.example.rentalcar.model.SubscribersEntity;
import com.example.rentalcar.service.subscribersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/subscribers")
public class sbController {
    @Autowired
    subscribersService subscribersService;
    @GetMapping(value = "")
    public String showSubscribers(Model model){
        List<SubscribersEntity> subscribers = subscribersService.listsSubscribers();
        model.addAttribute("lsSb",subscribers);
        return "adminlte/subscribers/list";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        subscribersService.deleteSb(id);
        return "redirect:/admin/subscribers";
    }
    //add
    @PostMapping("/save")
    public String addUser(@Valid SubscribersEntity sb, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "adminlte/subscribers/list";
        }

        subscribersService.saveSubscribers(sb);
        return "redirect:/admin/subscribers";
    }
    //edit form
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        SubscribersEntity sb = subscribersService.findSbById(id);

        model.addAttribute("sb", sb);
        return "adminlte/subscribers/edit";
    }
    //update
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid SubscribersEntity sb,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            sb.setId(id);
            return "adminlte/subscribers/edit";
        }

        subscribersService.saveSubscribers(sb);
        return "redirect:/admin/subscribers";
    }
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
//
//    @ExceptionHandler({ ConstraintViolationException.class })
//    public ResponseEntity<Object> handleConstraintViolation(
//            ConstraintViolationException ex, WebRequest request) {
//        List<String> errors = new ArrayList<String>();
//        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
//            errors.add(violation.getRootBeanClass().getName()  + " "
//                    + violation.getPropertyPath() + ": "
//                    + violation.getMessage());
//        }
//
//        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
//    }


}
