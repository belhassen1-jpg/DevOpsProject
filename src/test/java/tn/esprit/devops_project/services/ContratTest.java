import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContratServiceImplTest {

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private ContratServiceImpl contratService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllContrats() {
        List<Contrat> contrats = new ArrayList<>();
        contrats.add(new Contrat());
        contrats.add(new Contrat());

        when(contratRepository.findAll()).thenReturn(contrats);

        List<Contrat> result = contratService.retrieveAllContrats();

        assertEquals(2, result.size());
    }

    @Test
    public void testUpdateContrat() {
        Contrat contrat = new Contrat();


        when(contratRepository.save(contrat)).thenReturn(contrat);
        Contrat result = contratService.updateContrat(contrat);

        assertNotNull(result);
    }
}
