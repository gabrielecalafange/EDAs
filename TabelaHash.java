import java.util.HashSet;
import java.util.Set;

public class TabelaHash {
    
    private String[] tabela;
    private Set<Integer> chaves;
    private Set<String> valores;
    private int size;
    public static final double FATOR_DE_CARGA_DEFAULT = 0.75;
    public static final int CAPACIDADE_DEFAULT = 7; // usar sempre um número primo 
    public static final String flag = new String("apagado");

    public TabelaHash() {
        this.tabela = new String[CAPACIDADE_DEFAULT];
        this.chaves = new HashSet<Integer>();
        this.valores = new HashSet<String>();
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    private int hash(Integer chave) {
        return chave % this.tabela.length;
    }

    public Set<Integer> getKeys() {
        return this.chaves;
    }

    public Set<String> getValues() {
        return this.valores;
    }

    

}
