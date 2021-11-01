package com.equeue.service;

import com.equeue.dto.UserDTO;
import com.equeue.mapper.Mapper;
import com.equeue.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByUsername(username) == null) {
            throw new UsernameNotFoundException("User not found");
        } else
            return mapper.toUserDTO(userRepository.findByUsername(username));
    }

    @Transactional
    public void saveUser(UserDTO userDTO) {
        userRepository.save(mapper.toUser(userDTO));
    }

}
