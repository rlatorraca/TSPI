package testes;

import numeros.Numeros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {

    private Numeros numero;

    @Before // Roda antes do @Test
    public void setUp() {
        numero = new Numeros();
    }

    @Test
    public void validarSeUmNumeroEhUmaUnidade(){

        // utilizar é uma unidade passando o valor 9 que trata-se uma unidade
        boolean unidade = numero.ehUmaUnidade(9);

        //validar quer a resposta é TRUE
        Assert.assertTrue(unidade);
    }

    @Test
    public void validarSeUmNumeroNaoEhUmaUnidade(){

        // utilizar é uma unidade passando o valor 10 que NAO se trata de uma unidade
        boolean unidade = numero.ehUmaUnidade(10);

        //validar quer a resposta é TRUE
        Assert.assertFalse(unidade);
    }
}
