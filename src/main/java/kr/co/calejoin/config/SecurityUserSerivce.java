

package kr.co.calejoin.config;

import kr.co.calejoin.entity.UserEntity;
import kr.co.calejoin.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SecurityUserSerivce implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) {
	
		UserEntity user = repo.findById(username).orElse(null);

		if(user == null) {
			throw new UsernameNotFoundException("not found username : " + username);
		}

		UserDetails userDetails = MyUserDetails.builder()
				.user(user)
				.build();

		log.info("UserDetailsService : "+userDetails);
		return userDetails;
	}

}