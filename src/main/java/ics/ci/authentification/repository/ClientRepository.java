package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
