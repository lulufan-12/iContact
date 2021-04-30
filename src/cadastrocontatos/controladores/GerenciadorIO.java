package cadastrocontatos.controladores;
import cadastrocontatos.entidades.Contato;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import sun.misc.IOUtils;

/**
 *
 * @author luluf
 */
public class GerenciadorIO {
    private static final String CONTATOS_URL = System.getProperty("user.home") + "\\Documents\\iContact\\Contatos.bin";
    private static final String CONTATOS_PESSOAIS_URL = System.getProperty("user.home") + "\\Documents\\iContact\\ContatosPessoais.bin";
    private static final String CLIENTES_URL = System.getProperty("user.home") + "\\Documents\\iContact\\Clientes.bin";
    private static final String FORNECEDORES_URL = System.getProperty("user.home") + "\\Documents\\iContact\\Fornecedores.bin";
    private static final String DIR = System.getProperty("user.home") + "\\Documents\\iContact";
    
    public static void criarArquivos(){
        File dir = new File(DIR);
        File file_contatos = new File(CONTATOS_URL);
        File file_pessoais = new File(CONTATOS_PESSOAIS_URL);
        File file_fornecedores = new File(FORNECEDORES_URL);
        File file_clientes = new File(CLIENTES_URL);
        try{
            dir.mkdir();
            file_contatos.createNewFile();
            file_pessoais.createNewFile();
            file_fornecedores.createNewFile();
            file_clientes.createNewFile();
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    private static void salvarListaContatos(List<Contato> lista_contato, String path) throws IOException {
        File file = new File(path);
        ObjectOutputStream out = null; 
        
        out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(lista_contato);
        out.close();
    }
    
    public static void salvarOutrosContatos(List<Contato> lista_contatos){
        try{
            salvarListaContatos(lista_contatos, CONTATOS_URL);
            //salvarListaContatos(lista_contatos, "src/resources/Contatos.bin");
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void salvarContatosPessoais(List<Contato> lista_contatos){
        try{
            salvarListaContatos(lista_contatos, CONTATOS_PESSOAIS_URL);
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void salvarClientes(List<Contato> lista_contatos){
        try{
            salvarListaContatos(lista_contatos, CLIENTES_URL);
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void salvarFornecedores(List<Contato> lista_contatos){
        try{
            salvarListaContatos(lista_contatos, FORNECEDORES_URL);
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
    private static List<Contato> buscarListaContatos(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File(path);
        List<Contato> lista = null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        lista = (List<Contato>) in.readObject();
        
        return lista;
    }
    
    public static List<Contato> buscarOutrosContatos(){
        try{
            List<Contato> lista = buscarListaContatos(CONTATOS_URL);
            return lista;
        }
        catch(ClassNotFoundException e){
            System.err.println("Classe não encontrada: " + e.getMessage());
            return new ArrayList<Contato>();
        }
        catch(IOException e){
            System.err.println("Erro de IO: " + e.getMessage());
            return new ArrayList<Contato>();
        }
    }
    
    public static List<Contato> buscarContatosPessoais(){
        try{
            List<Contato> lista = buscarListaContatos(CONTATOS_PESSOAIS_URL);
            return lista;
        }
        catch(ClassNotFoundException e){
            System.err.println("Classe não encontrada: " + e.getMessage());
            return new ArrayList<Contato>();
        }
        catch(IOException e){
            System.err.println("Erro de IO: " + e.getMessage());
            return new ArrayList<Contato>();
        }
    }
    
    public static List<Contato> buscarClientes(){
        try{
            List<Contato> lista = buscarListaContatos(CLIENTES_URL);
            return lista;
        }
        catch(ClassNotFoundException e){
            System.err.println("Classe não encontrada: " + e.getMessage());
            return new ArrayList<Contato>();
        }
        catch(IOException e){
            System.err.println("Erro de IO: " + e.getMessage());
            return new ArrayList<Contato>();
        }
    }
    
    public static List<Contato> buscarFornecedores(){
        try{
            List<Contato> lista = buscarListaContatos(FORNECEDORES_URL);
            return lista;
        }
        catch(ClassNotFoundException e){
            System.err.println("Classe não encontrada: " + e.getMessage());
            return new ArrayList<Contato>();
        }
        catch(IOException e){
            System.err.println("Erro de IO: " + e.getMessage());
            return new ArrayList<Contato>();
        }
    }
    
    public static byte[] carregarIcone(){
        String imgName = "/resources/imgs/icone.png";
        InputStream is = GerenciadorIO.class.getResourceAsStream(imgName);
        
        
        byte[] buffer = new byte[436];
        int counter = 0;
        try{
            while(true){
                int aux = is.read();
                if(aux == -1) break;
                buffer[counter] = (byte) aux;
                counter++;
            }
            is.close();
        }
        catch(IOException e){
            e.getMessage();
        }
        return buffer;
    }
}
