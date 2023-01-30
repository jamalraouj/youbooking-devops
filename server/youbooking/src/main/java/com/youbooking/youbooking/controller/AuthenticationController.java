package com.youbooking.youbooking.controller;


import com.youbooking.youbooking.DtoToEntity;
import com.youbooking.youbooking.configspringsecurity.JwtUtils;
import com.youbooking.youbooking.controller.vm.ResponseVm;
import com.youbooking.youbooking.entity.UserEntity;
import com.youbooking.youbooking.service.UserService;
import com.youbooking.youbooking.service.dto.AuthenticationRequest;
import com.youbooking.youbooking.service.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/youbooking/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    @ResponseBody
    public ResponseEntity<ResponseVm> authenticate(@RequestBody AuthenticationRequest request){

        Optional<UserEntity> user = Optional.ofNullable(userService.findByEmail(request.getEmail()));
        System.out.println(user);
        if(user.isPresent() && user.get().isActive()){
            return ResponseEntity.ok(new ResponseVm(HttpStatus.ACCEPTED , "Success" ,Collections.singletonList(jwtUtils.generateToken(new User(user.get().getEmail(),user.get().getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.get().getRole().toString())))) )));
        }
        return ResponseEntity.ok(new ResponseVm(HttpStatus.BAD_REQUEST , user.get().getMessage().getMessage()));
    }
    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<ResponseVm> signup(@Valid @RequestBody RegisterDTO registerDTO){

        UserEntity userEntity = userService.register(registerDTO);
       return ResponseEntity.ok(new ResponseVm(HttpStatus.ACCEPTED , "Success" , Collections.singletonList(userEntity)));

    }
}
