package ics.ci.authentification.repository;

//import org.springframework.transaction.annotation.Transactional;
import ics.ci.authentification.entity.Operation;
import ics.ci.authentification.entity.Reception;

import javax.transaction.Transactional;
import java.util.List;

//@NoRepositoryBean
@Transactional
public interface OperationRepository extends OperationBaseRepository<Operation> {

}
