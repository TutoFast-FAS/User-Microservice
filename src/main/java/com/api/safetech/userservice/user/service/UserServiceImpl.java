package com.api.safetech.userservice.user.service;

import com.api.safetech.userservice.shared.exception.ResourceNotFoundException;
import com.api.safetech.userservice.shared.exception.ResourceValidationException;
import com.api.safetech.userservice.user.domain.model.entity.User;
import com.api.safetech.userservice.user.domain.persistence.UserRepository;
import com.api.safetech.userservice.user.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final static String ENTITY = "User";

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll(){return userRepository.findAll();}

    @Override
    public User getById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findByFirstNameAndLastNameContaining(firstName, lastName);
    }

    @Override
    public User create(User request){
        //Set<ConstraintViolation<User>> violations = validator.validate(request);
        //if(!violations.isEmpty())
        // throw new ResourceValidationException(ENTITY, violations);

        try{
            return userRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving user");
        }
    }

    @Override
    public User update(Long userId, User request){
        //Set<ConstraintViolation<User>> violations = validator.validate(request);
        //if(!violations.isEmpty())
        // throw new ResourceValidationException(ENTITY, violations);

        try{
            return userRepository.findById(userId)
                    .map(user->
                            userRepository.save(
                                    user.withFirstName(request.getFirstName())
                                            .withLastName(request.getLastName())
                                            .withDni(request.getDni())
                                            .withEmail(request.getEmail())
                                            .withPassword(request.getPassword())
                                            .withAddress(request.getAddress())
                                            .withPhone(request.getPhone())
                                            .withBirthday(request.getBirthday())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating user");
        }
    }

    @Override
    public User delete(Long userId){
        return userRepository.findById(userId)
                .map(user-> {
                    userRepository.delete(user);
                    return user;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }

}