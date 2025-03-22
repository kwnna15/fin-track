package se.mycompany.fin.track.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.mycompany.fin.track.repository.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {}
