package Login.autenticacao.domain.pessoa;

import Login.autenticacao.domain.endereco.DadosEndereco;

public record DadosCadastroPessoa(

        String nome,
        String email,
        DadosEndereco endereco
) {
}
