package br.com.ph23.usuarios.usuarios.repository;

import br.com.ph23.usuarios.usuarios.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
