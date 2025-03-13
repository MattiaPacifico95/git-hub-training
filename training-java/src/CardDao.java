import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<UserEntity> utenti;

    public UserDAO() {
        this.utenti = new ArrayList<>();
    }

    // Aggiunge un nuovo utente
    public void aggiungiUtente(UserEntity utente) {
        utenti.add(utente);
    }

    // Trova un utente per ID
    public UserEntity trovaUtentePerId(long idUtente) {
        for (UserEntity utente : utenti) {
            if (utente.getIdUtente() == idUtente) {
                return utente;
            }
        }
        return null; // Nessun utente trovato
    }

    // Aggiorna il nome dell'utente
    public boolean aggiornaNomeUtente(long idUtente, String nuovoNome) {
        UserEntity utente = trovaUtentePerId(idUtente);
        if (utente != null) {
            utente.setNome(nuovoNome);
            return true;
        }
        return false;
    }

    // Restituisce tutti gli utenti
    public List<UserEntity> getTuttiGliUtenti() {
        return utenti;
    }
}