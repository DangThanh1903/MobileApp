package org.example.mobileapp.repository;
import org.example.mobileapp.model.GameAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameAccountRepository extends JpaRepository<GameAccount, Long> {
}
