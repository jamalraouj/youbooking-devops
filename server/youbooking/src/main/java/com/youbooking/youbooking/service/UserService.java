package com.youbooking.youbooking.service;

import com.youbooking.youbooking.DtoToEntity;
import com.youbooking.youbooking.classes.Message;
import com.youbooking.youbooking.entity.Client;
import com.youbooking.youbooking.entity.Proprietary;
import com.youbooking.youbooking.entity.Role;
import com.youbooking.youbooking.entity.UserEntity;
import com.youbooking.youbooking.repository.UserRepository;
import com.youbooking.youbooking.service.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAdmins(){
        return userRepository.findAll();
    }
    public UserEntity findByEmail(String email){
        Optional<UserEntity> adminOptional = Optional.empty();
        Message message = new Message();
        if(email == null || email == ""){
            message.setMessage("You must adding email");
            message.setState("Error");
        }else {
            adminOptional = userRepository.findUserEntityByEmail(email);
            if(adminOptional.isPresent() && adminOptional.get().isActive()){
                message.setMessage("Success");
                message.setState("Success");
            }
            else {
                message.setMessage("This email does not exist");
                message.setState("ERROR");
            }
        }
        adminOptional.get().setMessage(message);
        return adminOptional.get();
    }
    public UserEntity register(RegisterDTO registerDTO){
            Optional<UserEntity> user =  userRepository.findUserEntityByEmail(registerDTO.getEmail());
            if (user.isPresent()){
                UserEntity u= DtoToEntity.userDtoToUser(registerDTO);
              u.setMessage(new Message("ERROR","This Email is exist"));
                return u;
            }

        if(registerDTO.isIshotelmanager()){
            Proprietary proprietary = new Proprietary(registerDTO.getEmail() , registerDTO.getPassword() , true );
            userRepository.save(proprietary);
            return proprietary;
        }else {
            Client client = new Client(registerDTO.getName() , registerDTO.getLastName() , registerDTO.getEmail() , registerDTO.getPassword() ,true);
            userRepository.save(client);
            return client;
        }

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> adminOptional = (userRepository.findUserEntityByEmail(email));
        if (adminOptional.isEmpty())
            throw new UsernameNotFoundException("user with email "+email+" not found");
        return new User(adminOptional.get().getEmail(),adminOptional.get().getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_"+adminOptional.get().getRole().toString())));
    }
}