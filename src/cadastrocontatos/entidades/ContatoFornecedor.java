package cadastrocontatos.entidades;

import java.io.Serializable;

/**
 *
 * @author luluf
 */
public class ContatoFornecedor extends Contato {
    private String cnpj;
    private String fax;

    public ContatoFornecedor() {
    }

    public ContatoFornecedor(String fax, String nome, String email, String telefone) {
        super(nome, email, telefone);
        this.fax = fax;
    }

    public ContatoFornecedor(String cnpj, String fax, String nome, String email, String telefone) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
        this.fax = fax;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
}
