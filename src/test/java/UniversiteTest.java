import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;

import java.util.HashSet;
import java.util.Set;

public class UniversiteTest {

    @Test
    public void testGetSetIdUniv() {
        // Create an instance of Universite
        Universite universite = new Universite();

        // Set the ID
        Integer id = 1;
        universite.setIdUniv(id);

        // Verify
        Assertions.assertEquals(id, universite.getIdUniv());
    }

    @Test
    public void testGetSetNomUniv() {
        // Create an instance of Universite
        Universite universite = new Universite();

        // Set the name
        String nomUniv = "Test University";
        universite.setNomUniv(nomUniv);

        // Verify
        Assertions.assertEquals(nomUniv, universite.getNomUniv());
    }

    @Test
    public void testGetSetDepartements() {
        // Create an instance of Universite
        Universite universite = new Universite();

        // Create a set of Departements
        Set<Departement> departements = new HashSet<>();
        // Add departements to the set...

        // Set the departements
        universite.setDepartements(departements);

        // Verify
        Assertions.assertEquals(departements, universite.getDepartements());
    }

    @Test
    public void testToString() {
        // Create an instance of Universite
        Universite universite = new Universite();
        universite.setIdUniv(1);
        universite.setNomUniv("Test University");

        // Verify the toString method
        Assertions.assertEquals(
                "Universite{idUniv=1, nomUniv='Test University', departements=null}",
                universite.toString()
        );
    }
}
