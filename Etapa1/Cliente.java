
import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String telFixo;
    private String telCelular;
    protected ArrayList <ContaCorrente> contas = new ArrayList();
    
    public Cliente(String nome, String telFixo, String telCelular){
        this.setNome(nome);
        this.setTelFixo(telFixo);
        this.setTelCelular(telCelular);
    }

    public void addContaCorrente(ContaCorrente conta){
        this.contas.add(conta);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }
}
