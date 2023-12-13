package tn.esprit.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entities.ResetPasswordToken;

import java.util.Date;

@Repository
public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Long> {
    ResetPasswordToken findByToken(String token);
    void deleteByExpiryDateBefore(Date now);
}
