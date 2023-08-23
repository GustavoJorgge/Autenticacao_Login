package Login.autenticacao.Controller;

import Login.autenticacao.domain.pessoa.DadosCadastroPessoa;
import Login.autenticacao.domain.pessoa.Pessoa;
import Login.autenticacao.domain.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public void cadastrar(@RequestBody DadosCadastroPessoa dados){
        var pessoa = new Pessoa(dados);
       repository.save(pessoa);
    }
}
