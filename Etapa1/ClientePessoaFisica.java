public class ClientePessoaFisica extends Cliente{
    private String cpf;

    public ClientePessoaFisica(String cpf, String nome, String telFixo, String telCelular) {
        super(nome, telFixo, telCelular);
        this.setCpf(cpf);
    }

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
