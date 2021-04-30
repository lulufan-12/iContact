package cadastrocontatos.entidades;

import java.io.Serializable;

/**
 *
 * @author luluf
 */
public class ContatoCliente extends ContatoFornecedor {
    private String cpf;
    private String telefoneTrabalho;
    private String celular;

    public ContatoCliente() {
    }

    public ContatoCliente(String telefoneTrabalho, String celular, String cnpj, String fax, String nome, String email, String telefone) {
        super(cnpj, fax, nome, email, telefone);
        this.telefoneTrabalho = telefoneTrabalho;
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
