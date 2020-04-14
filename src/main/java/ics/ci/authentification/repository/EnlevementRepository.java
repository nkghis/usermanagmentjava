package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Enlevement;

import javax.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EnlevementRepository extends OperationBaseRepository<Enlevement> {

    //public Enlevement findTopByOrderByOperationIdDesc();
}
