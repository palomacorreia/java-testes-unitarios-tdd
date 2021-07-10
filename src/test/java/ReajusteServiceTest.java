import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
   private ReajusteService service;
   private Funcionario funcionario;

    @BeforeEach
    public void init(){
        System.out.println("Antes de cada teste");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("3600"));
    }

    @AfterEach
    public void AfterEach(){
        System.out.println("Depois de cada Teste");
    }

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("Antes de todos");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Depois de todos");
    }


    @Test
    public void reajuste3PorcentoResultadoADesejar(){
        service.reajustePromocao(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("3708.00"),funcionario.getSalario());
    }

    @Test
    public void reajuste15PorcentoResultadoBom(){
        service.reajustePromocao(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("4140.00"),funcionario.getSalario());
    }

    @Test
    public void reajuste20PorcentoResultadoAOtimo(){
        service.reajustePromocao(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("4320.00"),funcionario.getSalario());
    }
}
