import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajuste3PorcentoResultadoADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("3600"));
        service.reajustePromocao(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("3708.00"),funcionario.getSalario());
    }

    @Test
    public void reajuste15PorcentoResultadoBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("3600"));
        service.reajustePromocao(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("4140.00"),funcionario.getSalario());
    }

    @Test
    public void reajuste20PorcentoResultadoAOtimo(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("3600"));
        service.reajustePromocao(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("4320.00"),funcionario.getSalario());
    }
}
