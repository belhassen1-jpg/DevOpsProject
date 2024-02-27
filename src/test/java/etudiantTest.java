import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

    @ExtendWith(MockitoExtension.class)
    public class etudiantTest {



        @Mock
        private Departement departementMock;

        @Mock
        private List<Equipe> equipesMock;

        @InjectMocks
        private Etudiant etudiant;

            @Test
            void testGetSetIdEtudiant() {
                // Définition de l'ID
                Integer id = 1;
                etudiant.setIdEtudiant(id);

                // Vérification
                assertEquals(id, etudiant.getIdEtudiant());
            }

            @Test
            void testGetSetNomE() {
                // Définition du nom
                String nom = "Nom de l'étudiant";
                etudiant.setNomE(nom);

                // Vérification
                assertEquals(nom, etudiant.getNomE());
            }

            @Test
            void testGetSetPrenomE() {
                // Définition du prénom
                String prenom = "Prénom de l'étudiant";
                etudiant.setPrenomE(prenom);

                // Vérification
                assertEquals(prenom, etudiant.getPrenomE());
            }




            @Test
            void testSetGetDepartement() {
                // Définition du département
                etudiant.setDepartement(departementMock);

                // Vérification
                assertEquals(departementMock, etudiant.getDepartement());
            }

            @Test
            void testSetGetEquipes() {
                // Définition des équipes
                etudiant.setEquipes(equipesMock);

                // Vérification
                assertEquals(equipesMock, etudiant.getEquipes());
            }
        }

