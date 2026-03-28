package in.su.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.su.main.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
}
