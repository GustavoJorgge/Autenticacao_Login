package Login.autenticacao.Controller;

import Login.autenticacao.domain.endereco.DadosEndereco;
import Login.autenticacao.domain.endereco.Endereco;
import Login.autenticacao.domain.pessoa.DadosCadastroPessoa;
import Login.autenticacao.domain.pessoa.DadosListaPessoa;
import Login.autenticacao.domain.pessoa.Pessoa;
import Login.autenticacao.domain.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

   @Autowired
   private PessoaRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListaPessoa>> listar_pessoas(@PageableDefault Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListaPessoa::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPessoa dados) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);
    }
}
