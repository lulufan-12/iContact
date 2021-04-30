package cadastrocontatos.controladores;

import cadastrocontatos.entidades.Contato;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luluf
 */
public class ModeloTabela extends AbstractTableModel{
    private List<Contato> lista_contatos;
    private final String[] COLUNAS = {"Nome do contato", "E-mail", "Telefone"};
    
    public ModeloTabela(){
        super();
        lista_contatos = new ArrayList<Contato>();
    }
    
    public ModeloTabela(List<Contato> lista){
        super();
        lista_contatos = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista_contatos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUNAS.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUNAS[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contato contato = lista_contatos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return contato.getNome();
            case 1:
                return contato.getEmail();
            case 2:
                return contato.getTelefone();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Contato contato = lista_contatos.get(rowIndex);
        contato.setNome(aValue.toString());
    }
    
    public Contato getContato(int index){
        return lista_contatos.get(index);
    }
    
    public void insertContato(Contato contato){
        lista_contatos.add(contato);
        int last = getRowCount() - 1;
        fireTableRowsInserted(last, last);
    }
    
    public void setContato(int index, Contato contato){
        lista_contatos.set(index, contato);
        fireTableRowsUpdated(index, index);
    }
    
    public void deleteContato(int index){
        lista_contatos.remove(index);
        fireTableRowsDeleted(index, index);
    }
}
