package tidus.users_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tidus.users_control.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
