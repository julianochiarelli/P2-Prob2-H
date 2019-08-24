/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhchiarelli
 */
public class ContaCorrenteTest {
    
    public ContaCorrenteTest() {
    }

    ClientePessoaFisica cliente1 = new ClientePessoaFisica("58932166930",
                                                            "Ricardo",
                                                            "(47)33829629",
                                                            "(47)965332695");
    ContaCorrente conta1 = new ContaCorrente(147848,
                                            63265,
                                            cliente1,
                                            500.0);
    
    ClientePessoaFisica cliente2 = new ClientePessoaFisica("58932566930",
                                                            "Mathes",
                                                            "(47)33829659",
                                                            "(47)965332395");
    ContaCorrente conta2 = new ContaCorrente(157848,
                                            63365,
                                            cliente2,
                                            600.0);
    
 
    @Test
    public void testSacar() {
        System.out.println("sacar");
        conta1.sacar(100.0);
        assertEquals(400.0, conta1.getSaldo(),0);
    }

   
    @Test
    public void testDepositar() {
        System.out.println("depositar");
        conta1.depositar(100.0);
        assertEquals(600.0, conta1.getSaldo(),0);
    }

   
    @Test
    public void testTransferir() {
        System.out.println("transferir");
        conta1.transferir(100, conta2);
        assertEquals(400.0, conta1.getSaldo(),0);
        assertEquals(700.0, conta2.getSaldo(),0);
    }
  
}
