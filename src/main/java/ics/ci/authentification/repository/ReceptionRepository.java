package ics.ci.authentification.repository;

//import org.springframework.transaction.annotation.Transactional;
import ics.ci.authentification.entity.Operation;
import ics.ci.authentification.entity.Reception;

        import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ReceptionRepository extends OperationBaseRepository<Reception> {
    //

}
