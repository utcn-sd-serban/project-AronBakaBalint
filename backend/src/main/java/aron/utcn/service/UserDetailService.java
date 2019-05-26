package aron.utcn.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import aron.utcn.model.Person;
import aron.utcn.persistence.jdbc.JdbcPersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserDetailService implements UserDetailsService {

	private final JdbcPersonRepository personRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person user = personRepository.getPersonByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		return new User(user.getUsername(), user.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
	}
}
