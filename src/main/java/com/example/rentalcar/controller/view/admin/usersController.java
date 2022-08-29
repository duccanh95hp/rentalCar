package com.example.rentalcar.controller.view.admin;

import com.example.rentalcar.common.Constants;
import com.example.rentalcar.model.RolesEntity;
import com.example.rentalcar.model.UsersEntity;
import com.example.rentalcar.payload.RegisterUser;
import com.example.rentalcar.service.FileStorageService;
import com.example.rentalcar.service.RoleServices;
import com.example.rentalcar.service.userSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class usersController {
    @Autowired
    FileStorageService storageService;
    @Autowired
    userSerice userSerice;
    @Autowired
    RoleServices roleServices;

    @Autowired
    PasswordEncoder encoder;



    @GetMapping(value = "")
    public String showUsers(Model model){
        List<UsersEntity> users = userSerice.listsUsers();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UsersEntity u = userSerice.findByUsername(username);
        model.addAttribute("users",users);
        model.addAttribute("u",u);
        return "adminlte/user/list";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        userSerice.deleteUser(id);
        return "redirect:/admin/user";
    }

    //add
    @PostMapping(value = "/save",consumes = {"multipart/form-data"})
    public String addUser(@RequestParam(value = "file",defaultValue = "") MultipartFile file,

                          @RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("address") String address,
                          @RequestParam("password") String password,
                          @RequestParam("telephone") String telephone,
                          @RequestParam("cmt") Integer cmt,
                          @RequestParam("passport") Integer passport,
                          @RequestParam("status") Integer status) {
        String path = storageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(path)
                .toUriString();
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        UsersEntity user = new UsersEntity();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        user.setPassword(encoder.encode(password));
        user.setTelephone(telephone);
        user.setCmt(cmt);
        user.setPassport(passport);
        user.setStatus(status);
        user.setAvatar(fileDownloadUri);

        userSerice.saveUsers(user);
        return "redirect:/user";
    }
    //edit form
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        UsersEntity user = userSerice.findUserById(id);

        model.addAttribute("user", user);
        return "adminlte/user/edit";
    }
    //update
    @PostMapping(value = "/update/{id}",consumes = {"multipart/form-data"})
    public String updateUser(@PathVariable("id") long id,
                             @RequestParam(value = "file",defaultValue = "") MultipartFile file,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("address") String address,
                             @RequestParam("password") String password,
                             @RequestParam("telephone") String telephone,
                             @RequestParam("cmt") Integer cmt,
                             @RequestParam("passport") Integer passport,
                             @RequestParam("status") Integer status) {
        UsersEntity oldUser = userSerice.findUserById(id);
        String path = storageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(path)
                .toUriString();

        oldUser.setName(name);
        oldUser.setEmail(email);
        oldUser.setAddress(address);
        if(password == null){
            oldUser.setPassword(oldUser.getPassword());
        }else {
            oldUser.setPassword(encoder.encode(password));
        }


        oldUser.setTelephone(telephone);
        oldUser.setCmt(cmt);
        oldUser.setPassport(passport);
        oldUser.setStatus(status);
        if(file == null){
            oldUser.setAvatar(oldUser.getAvatar());
        }else {
            oldUser.setAvatar(fileDownloadUri);
        }



        userSerice.saveUsers(oldUser);
        return "redirect:/user";
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

    @GetMapping(value = "addForm")
    public String addUser(){
        return "/adminlte/user/add";
    }

    @PostMapping("/adduser")
    public String addUse(@Valid UsersEntity user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/adminlte/user/add";
        }

        userSerice.saveUsers(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        return "adminlte/login/register";
    }

    @RequestMapping(value = "/registersubmit", method = RequestMethod.POST)
    public String registersubmit(@ModelAttribute RegisterUser registerUser) {
        if(userSerice.existsByUsername(registerUser.getUsername())) {
            //Co ton tai roi
        } else {
            //Chua ton tai username
            UsersEntity u = new UsersEntity();
            u.setName(registerUser.getUsername());
            String password = encoder.encode(registerUser.getPassword());
            u.setPassword(password);

            Set<RolesEntity> roles = new HashSet<RolesEntity>();
            RolesEntity r = roleServices.findByName(Constants.ROLE_USER).get();
            roles.add(r);

            u.setRoles(roles);

            userSerice.saveUsers(u);
        }
        return "redirect:/login";
    }
}
