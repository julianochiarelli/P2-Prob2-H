
import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {
    private int numero;
    private int agencia;
    private Cliente cliente;
    private Double saldo;
    private ArrayList <Operacao> operacoes = new ArrayList();

    public ContaCorrente(int numero, int agencia, Cliente cliente, Double saldo) {
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.setCliente(cliente);
        this.setSaldo(saldo);
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    public void addOperacao(Operacao operacao){
        this.operacoes.add(operacao);
    }
    
    public void sacar (double valor){
        Date data = new Date(System.currentTimeMillis());
        TipoOperacao tipoOperacao = TipoOperacao.SAIDA;
        Operacao operacao = new Operacao(valor,
                                        this.saldo,
                                        tipoOperacao,
                                        this,
                                        data);
        this.addOperacao(operacao);
        this.saldo -= valor;
        System.out.println("Cliente " + this.cliente.getNome() + ", Conta " + this.getNumero() + ", Saque de " + valor 
                + " - Serviço de Análise de Fluxo de Caixa");
    }
    
    public void depositar (double valor){
        Date data = new Date(System.currentTimeMillis());
        TipoOperacao tipoOperacao = TipoOperacao.ENTRADA;
        Operacao operacao = new Operacao(valor,
                                        this.saldo,
                                        tipoOperacao,
                                        this,
                                        data);
        this.addOperacao(operacao);
        this.saldo += valor;
        System.out.println("Cliente " + this.cliente.getNome() + ", Conta " + this.getNumero() + ", Deposito de " + valor 
                + " - Serviço de Análise de Fluxo de Caixa");
    }
    
    public void transferir (double valor, ContaCorrente contaDestino){
        Date data = new Date(System.currentTimeMillis());
        TipoOperacao operacaoEntrada = TipoOperacao.ENTRADA;
        TipoOperacao operacaoSaida = TipoOperacao.SAIDA;
        OperacaoTransferencia Saida = new OperacaoTransferencia(contaDestino,
                                        valor,
                                        this.saldo,
                                        operacaoSaida,
                                        this,
                                        data);
        addOperacao(Saida);
        this.saldo -= valor;
        OperacaoTransferencia Entrada = new OperacaoTransferencia(this,
                                        valor,
                                        this.saldo,
                                        operacaoEntrada,
                                        contaDestino,
                                        data);
        contaDestino.addOperacao(Entrada);
        contaDestino.receberTransferencia(valor, this);
        System.out.println("Cliente " + this.cliente.getNome() + ", Conta " + this.getNumero() + ", Transferencia de " + valor 
                + " para conta " + contaDestino.getNumero() + " - Serviço de Análise de Fluxo de Caixa");
    }
    
    public void receberTransferencia(double valor, ContaCorrente origem){
        this.saldo += valor;
        System.out.println("Cliente " + this.cliente.getNome() + ", Conta " + this.getNumero() + ", Recebida transferencia de " + valor
                + " da conta " + origem.getNumero() + " - Serviço de Análise de Fluxo de Caixa");
    }
}
