package com.assignment.socialmediabackend.security.services;


import com.assignment.socialmediabackend.domain.model.User;
import com.assignment.socialmediabackend.domain.repository.UserRepository;
import com.assignment.socialmediabackend.utils.LoggedUserUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        System.out.println(username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with by " + username)
        );
        LoggedUserUtils.id = user.getId();
        LoggedUserUtils.username = user.getUsername();
        LoggedUserUtils.address = user.getAddress();
        LoggedUserUtils.email = user.getEmail();
        LoggedUserUtils.phone = user.getPhoneNo();
        LoggedUserUtils.name = user.getName();
        return UserPrinciple.build(user);
    }
}
