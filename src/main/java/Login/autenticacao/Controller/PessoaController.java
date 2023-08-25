package Login.autenticacao.Controller;

import Login.autenticacao.domain.endereco.DadosEndereco;
import Login.autenticacao.domain.endereco.Endereco;
import Login.autenticacao.domain.pessoa.DadosCadastroPessoa;
import Login.autenticacao.domain.pessoa.Pessoa;
import Login.autenticacao.domain.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("pessoas")
public class PessoaController {

   @Autowired
   private PessoaRepository repository;

    @GetMapping
    public String carregaPaginaCadastro(){
        return "pessoas/formulario";
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestParam String nome,
                          @RequestParam String email,
                          @RequestParam String logradouro,
                          @RequestParam String bairro,
                          @RequestParam String cep,
                          @RequestParam String cidade,
                          @RequestParam String uf,
                          @RequestParam String complemento,
                          @RequestParam String numero) {

        DadosEndereco endereco = new DadosEndereco(logradouro, bairro, cep, cidade, uf, complemento, numero);
        DadosCadastroPessoa dados = new DadosCadastroPessoa(nome, email, endereco);
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);
    }
}
