package Login.autenticacao.domain.pessoa;

public record DadosListaPessoa (Long id, String nome, String email) {

    public DadosListaPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
    }


}
