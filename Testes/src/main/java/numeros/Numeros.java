package numeros;

public class Numeros {

    public boolean ehUmaUnidade(int meuNumero) {
        boolean ehUnidade = true;

        if(meuNumero > 9) {
            ehUnidade = false;
        }

        return ehUnidade;
    }
}
