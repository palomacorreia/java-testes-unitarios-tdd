
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest extends BonusService {

    @Test
    void testCalcularBonusZero() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Paloma", LocalDate.now(), new BigDecimal(25000)));
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), bonus);
    }

    @Test
    void testCalcularBonusMenor() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Paloma", LocalDate.now(), new BigDecimal(2500)));
        assertEquals(new BigDecimal("250.00"), bonus);
    }
    @Test
    void testCalcularBonusIgual() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Paloma", LocalDate.now(), new BigDecimal(10000)));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
