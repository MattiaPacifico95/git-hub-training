package daos;

import com.spring.fidelity.spring_fidelity.entities.CredentialManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface CredentialManagerDao extends JpaRepository<CredentialManagerEntity, Long> {
    @NativeQuery("SELECT * FROM CREDENTIAL_MANAGER WHERE id_utente = ?")
    CredentialManagerEntity findByIdUtente(Long idUtente);
    @NativeQuery("SELECT * FROM CREDENTIAL_MANAGER WHERE id_dataCreazione = ?")
    CredentialManagerEntity findByDataCreazione(Timestamp dataCreazione);
    @NativeQuery("select * from credential_manager where password = ? and id_utente = ?")
    CredentialManagerEntity findByPasswordAndIdUtente(String password, Long idUtente);
    @NativeQuery("SELECT COUNT(*) FROM credential_manager WHERE id_utente = ? AND password = ?")
    public Integer checkOldPassword(int userId, String vecchiaPassword);
    @NativeQuery("UPDATE credential_manager SET password = ?, data_rinnovo = ? WHERE id_utente = ?")
    void updateOldPassword(int userId, String vecchiaPassword, Timestamp dataRinnovo);
    }

