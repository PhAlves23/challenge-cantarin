package br.com.ph23.usuarios.usuarios.service;

import br.com.ph23.usuarios.usuarios.model.UserModel;
import br.com.ph23.usuarios.usuarios.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
   private UserRepository userRepository;

    public List<UserModel> findAll() {
    return userRepository.findAll();
    }

    public UserModel create(UserModel model) {
        return userRepository.save(model);
    }

    public UserModel update(Long id, UserModel model) {
        UserModel userModel = new UserModel();
        var user = userRepository.getReferenceById(id);
        userModel.setId(user.getId());
        userModel.setName(model.getName());
        userModel.setEmail(model.getEmail());
        userModel.setPassword(model.getPassword());
        return userRepository.save(userModel);
    }

    public void delete(Long id) {
    userRepository.deleteById(id);
    }
}
