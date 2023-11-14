package toy.five.triprecord.global.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.five.triprecord.domain.user.entity.User;
import toy.five.triprecord.global.security.entity.RefreshToken;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<RefreshToken,Long> {
    public Optional<RefreshToken> findByEmail(String email);

}
