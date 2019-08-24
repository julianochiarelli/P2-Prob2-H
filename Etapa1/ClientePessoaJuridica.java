public class ClientePessoaJuridica extends Cliente{
    private String cnpj;
    private String servidorJMS;

    public ClientePessoaJuridica(String cnpj, String servidorJMS, String nome, String telFixo, String telCelular) {
        super(nome, telFixo, telCelular);
        this.setCnpj(cnpj);
        this.setServidorJMS(servidorJMS);
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getServidorJMS() {
        return servidorJMS;
    }

    public void setServidorJMS(String servidorJMS) {
        this.servidorJMS = servidorJMS;
    }
}
