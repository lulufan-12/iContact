package cadastrocontatos.excecoes;

/**
 *
 * @author luluf
 */
public class CnpjInvalidoException extends Exception {
    public String getMessage(){
        return "O CNPJ informado não é válido.";
    }
}
