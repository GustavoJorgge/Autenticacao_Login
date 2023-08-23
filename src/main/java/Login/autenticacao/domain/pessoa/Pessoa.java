package Login.autenticacao.domain.pessoa;

import Login.autenticacao.domain.endereco.Endereco;

public class Pessoa {

    private Long id;
    private String nome;
    private String email;

    private Endereco endereco;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.endereco = new Endereco(dados.endereco());
    }

}
