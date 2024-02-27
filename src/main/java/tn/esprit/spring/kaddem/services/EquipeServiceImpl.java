package tn.esprit.spring.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class EquipeServiceImpl implements IEquipeService{
	EquipeRepository equipeRepository;


	public List<Equipe> retrieveAllEquipes(){
	return  (List<Equipe>) equipeRepository.findAll();
	}
	public Equipe addEquipe(Equipe e){
		return (equipeRepository.save(e));
	}

	public  void deleteEquipe(Integer idEquipe){
		Equipe e=retrieveEquipe(idEquipe);
		equipeRepository.delete(e);
	}

	public Equipe retrieveEquipe(Integer equipeId) {
		Optional<Equipe> optionalEquipe = equipeRepository.findById(equipeId);
		return optionalEquipe.orElse(null);
	}


	public Equipe updateEquipe(Equipe e){
	return (	equipeRepository.save(e));
	}

	@Transactional
	public void evoluerEquipes() {
		List<Equipe> equipes = (List<Equipe>) equipeRepository.findAll();
		for (Equipe equipe : equipes) {
			if (equipe.getNiveau() == Niveau.JUNIOR || equipe.getNiveau() == Niveau.SENIOR) {
				int nbEtudiantsAvecContratsActifs = countEtudiantsAvecContratsActifs(equipe.getEtudiants());
				if (nbEtudiantsAvecContratsActifs >= 3) {
					if (equipe.getNiveau() == Niveau.JUNIOR) {
						equipe.setNiveau(Niveau.SENIOR);
					} else if (equipe.getNiveau() == Niveau.SENIOR) {
						equipe.setNiveau(Niveau.EXPERT);
					}
					equipeRepository.save(equipe);
				}
			}
		}
	}

	private int countEtudiantsAvecContratsActifs(Set<Etudiant> etudiants) {
		int count = 0;
		Date dateSysteme = new Date();
		for (Etudiant etudiant : etudiants) {
			Set<Contrat> contrats = etudiant.getContrats();
			boolean hasActiveContract = false;
			for (Contrat contrat : contrats) {
				if (Boolean.FALSE.equals(contrat.getArchive())) {
					long differenceInTime = dateSysteme.getTime() - contrat.getDateFinContrat().getTime();
					long differenceInYears = differenceInTime / (1000L * 60 * 60 * 24 * 365);
					if (differenceInYears > 1) {
						hasActiveContract = true;
						break;
					}
				}
			}
			if (hasActiveContract) {
				count++;
				if (count >= 3) {
					break;
				}
			}
		}
		return count;
	}
}