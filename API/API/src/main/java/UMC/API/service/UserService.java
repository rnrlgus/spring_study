package UMC.API.service;

import UMC.API.domain.User;
import UMC.API.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * create 회원가입
     * @param user 회원가입 할 User 객체
     * @return 회원가입한 User의 userId
     */
    public int join(User user) {
        userRepository.save(user);
        return user.getUserId();
    }

    /**
     * read 전체 회원 조회
     *
     * @return List<User> 전체 회원 목록
     */
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    /**
     * read 특정 회원 조회
     *
     * @param userName 회원 이름
     * @return Optional<User> 이름이 userName인 회원
     */
    public Optional<User> findOneMember(String userName) {
        return userRepository.findByName(userName);
    }

    public String deleteUser(String userName) {
        return userRepository.delete(userName);
    }

}
