package com.example.simplecrudapp.service;

import com.example.simplecrudapp.dto.UserDTO;
import com.example.simplecrudapp.entity.User;
import com.example.simplecrudapp.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }


    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    //select * from simplecrudapp where id=2
    public UserDTO getUserByUserID(String userID){
        User user=userRepo.getUserByUserId(userID);
        return modelMapper.map(user, UserDTO.class);
    }

    //select * from simplecrudapp where id=2 and address='kegalle'
    public UserDTO getUserByUserIDAndAddress(String userID, String address){
        User user=userRepo.getUserByUserIdAndAddress(userID, address);
        return modelMapper.map(user, UserDTO.class);
    }

}
