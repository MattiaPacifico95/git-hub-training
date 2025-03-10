import java.security.Timestamp;
import java.util.Date;

public class CardEntity {
    long id_tessera;
    long id_utente;
    int saldo_punti;
    Timestamp data_attivazione;

    public class CardEntity {


        // Getter e Setter per idCm
        public long getIdTessera() { return id_tessera; }
            return idTessera;
        }

        public void setIdUtente(long idUtente) {
            this.id_utente= idUtente;
        }

        // Getter e Setter per idUtente
        public long getIdUtente() {
            return idUtente;
        }

        public void setIdUtente(long idUtente) {
            this.idUtente = idUtente;
        }

        // Getter e Setter per psw
        public String getPsw() {
            return psw;
        }

        public void setPsw(String psw) {
            this.psw = psw;
        }

        // Getter e Setter per dataCreazione
        public Date getDataCreazione() {
            return dataCreazione;
        }

        public void setDataCreazione(Date dataCreazione) {
            this.dataCreazione = dataCreazione;
        }

        // Getter e Setter per dataRinnovo
        public Date getDataRinnovo() {
            return dataRinnovo;
        }

        public void setDataRinnovo(Date dataRinnovo) {
            this.dataRinnovo = dataRinnovo;
        }

        // Metodo toString per una rappresentazione leggibile
        @Override
        public String toString() {
            return "CredentialManagerEntity{" +
                    "idCm=" + idCm +
                    ", idUtente=" + idUtente +
                    ", psw='" + psw + '\'' +
                    ", dataCreazione=" + dataCreazione +
                    ", dataRinnovo=" + dataRinnovo +
                    '}';
        }

}
