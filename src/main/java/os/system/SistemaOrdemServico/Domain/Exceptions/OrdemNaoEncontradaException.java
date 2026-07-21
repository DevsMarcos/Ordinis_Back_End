package os.system.SistemaOrdemServico.Domain.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrdemNaoEncontradaException extends RuntimeException{
    public OrdemNaoEncontradaException(Long id) {
        super("Ordem não encontrada com o id: " + id);
    }
}
