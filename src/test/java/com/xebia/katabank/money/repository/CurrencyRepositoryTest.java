package test.java.com.xebia.katabank.money.repository;

import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.money.repository.CurrencyRepository;

import java.util.List;

/**
 * Tests de la classe CurrencyRepository
 */
public class CurrencyRepositoryTest {

    @Inject
    CurrencyRepository currencyRepository;

    @Test
    public void testGetCurrency(){
        Currency currency = new Currency("eur", "euro", "€");
        assertEquals(currency, currencyRepository.getCurrency("eur"));
    }

    @Test
    public void testAddCurrency(){
        Currency currency = new Currency("dol", "dollar", "$");
        currencyRepository.addCurrency(currency);
        assertNotNull(currencyRepository.getCurrency("dol"));
    }

    @Test
    public void testRemoveCurrency(){
        Currency currency = new Currency("eur", "euro", "€");
        currencyRepository.removeCurrency(currency);
        assertNull(currencyRepository.getCurrency("eur"));
    }

    @Test
    public void testUpdateCurrency(){
        Currency currency = new Currency("eur", "euro2", "€");
        currencyRepository.updateCurrency(currency);
        assertEquals("euro2", currencyRepository.getCurrency("eur").getName());
    }

    @Test
    public void testGetAllCurrencies(){
        Currency currency = new Currency("dol", "dollar", "$");
        currencyRepository.addCurrency(currency);
        List<Currency> currencyListTemoin = new ArrayList<>();
        currencyListTemoin.add(currency);
        currencyListTemoin.add( currencyRepository.getCurrency("eur"));
        List<Currency> results = currencyRepository.GetAllCurrencies();
        assertEquals(2, results.size());
        assertTrue(currencyListTemoin.containsAll(results));
    }
}
