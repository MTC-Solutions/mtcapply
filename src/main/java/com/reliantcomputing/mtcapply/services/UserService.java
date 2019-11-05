package com.reliantcomputing.mtcapply.services;

import com.reliantcomputing.mtcapply.constants.RoleConstants;
import com.reliantcomputing.mtcapply.controllers.dto.UserDto;
import com.reliantcomputing.mtcapply.models.auth.Authority;
import com.reliantcomputing.mtcapply.models.auth.User;
import com.reliantcomputing.mtcapply.repositories.UserRepository;
import com.reliantcomputing.mtcapply.security.SecurityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserService {

   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
      this.userRepository = userRepository;
      this.passwordEncoder = passwordEncoder;
   }

   @Transactional(readOnly = true)
   public Optional<User> getUserWithAuthorities() {
      return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
   }

   public User addApplicant(final UserDto userDto){

      //Create user object
      User user = new User();

      //Set the object state
      user.setActivated(true);
      user.setPassword(passwordEncoder.encode(userDto.getPassword()));
      user.setUsername(userDto.getEmail());
      user.setEmail(userDto.getEmail());

      //Create applicant authority
      Authority authority = new Authority();
      authority.setName(RoleConstants.ROLE_APPLICANT);

      Set<Authority> authorities = new HashSet<>();
      authorities.add(authority);

      //Add the authority to user authority collection
      user.setAuthorities(authorities);

      return userRepository.save(user);
   }

}
