package Login.autenticacao.domain.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    findAllByAtivoTrue
}
