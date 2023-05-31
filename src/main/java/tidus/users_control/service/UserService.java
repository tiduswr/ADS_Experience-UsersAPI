package tidus.users_control.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import tidus.users_control.model.User;
import tidus.users_control.model.UserType;
import tidus.users_control.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) throws ResponseStatusException{
        return userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(Long id, User user) throws ResponseStatusException{
        return userRepository.findById(id)
            .map(userDb -> {
                userDb.setName(user.getName());
                userDb.setDescription(user.getDescription());
                userDb.setDataNascimento(user.getDataNascimento());
                userDb.setUserType(user.getUserType());
                userRepository.save(userDb);
                return userDb;
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        userRepository.delete(user);
    }

}
