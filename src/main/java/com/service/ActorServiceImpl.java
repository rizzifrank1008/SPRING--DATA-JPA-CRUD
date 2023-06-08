package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Actor;
import com.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ActorRepository actorRepository;

	@Override
	public void checkSaveOrUpdateActor(Actor actor) {
		try {
			actorRepository.save(actor);
			log.info("Inserimento riuscito");
		} catch (Exception e) {
			log.info("Inserimento fallito");
			e.printStackTrace();
		}
	}

	@Override
	public void checkFindAllActors() {

	}

	@Override
	public void checkSaveListActor(List<Actor> actorList) {
		try {
			actorRepository.saveAll(actorList);
			log.info("Inserimento riuscito");
		} catch (Exception e) {
			log.info("Inserimento fallito");
			e.printStackTrace();
		}

	}

	/*
	 * Metodo che esegue un controllo sulle operazioni di inserimento e
	 * aggiornamento
	 */
//	@Override
//	public void checkSaveOrUpdateStudent(Student student) {
//		/*
//		 * Spring Data JPA esegue la seguente azione:
//		 * 
//		 * @PersistenceContext private EntityManager em;
//		 * em.persist(student)/em.merge(student);
//		 * 
//		 * JPA mette nel contesto di persistenza l'entity arrivata in input al metodo.
//		 * Hibernate si accorge dell'apertura di un contesto transazionale (in quanto
//		 * save è transactional di default) e traduce il persist/merge in una
//		 * insert/update sql, chiudendo infine la transaction
//		 * 
//		 */
//		try {
//			studentRepository.save(student);
//			log.info(studentSaveSuccess);
//			// le eccezioni catturate sono quelle che lancia il metodo save ovviamente
//		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
//			log.info(studentSaveFail);
//			e.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void checkDeleteStudent(String passportNumber) {
//		// questo if perché il metodo deleteById non ti lancia
//		// un'eccezione se la PK non esiste sul DB
//		if (studentRepository.existsById(passportNumber)) {
//			// quindi in teoria non ci sarebbe bisogno di questo try
//			// perché l'unica eccezione che lancia il metodo è una
//			// IllegalArgumentException qualora la PK fosse null
//			try {
//				studentRepository.deleteById(passportNumber);
//				log.info(studentDeleteSuccess);
//			} catch (IllegalArgumentException iae) {
//				log.info(studentDeleteFail1);
//				iae.printStackTrace();
//			}
//		} else {
//			log.info(studentDeleteFail2);
//		}
//
//	}
//
//	@Override
//	public void checkFindAllStudents() {
//		List<Student> students = studentRepository.findAll();
//		if (students != null && !students.isEmpty()) {
//			log.info(studentReadAllSuccess);
//			students.forEach(System.out::println);
//		} else {
//			log.info(studentReadFail);
//		}
//	}

}
