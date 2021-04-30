package cadastrocontatos.entidades;

/**
 *
 * @author luluf
 */
public class ContatoPessoal extends Contato {
    private String celular;

    public ContatoPessoal(String celular, String nome, String email, String telefone) {
        super(nome, email, telefone);
        this.celular = celular;
    }

    public ContatoPessoal() {
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
