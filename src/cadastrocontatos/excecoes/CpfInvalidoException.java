package cadastrocontatos.excecoes;

/**
 *
 * @author luluf
 */
public class CpfInvalidoException extends Exception {
    public String getMessage(){
        return "O CPF informado não é válido.";
    }
}
