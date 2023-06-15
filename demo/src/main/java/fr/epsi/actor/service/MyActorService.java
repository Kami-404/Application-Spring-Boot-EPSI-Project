package fr.epsi.actor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.repository.ActorRepository;

public class MyActorService implements ActorService {

    // private ActorRepository repo = new WebserviceRepository();
    private ActorRepository repo;

    public MyActorService(ActorRepository provideRepository) {
        this.repo = provideRepository;
    }

    @Override
    public Optional<Actor> getById(Integer id) {

        // return listerTousLesActeurs().stream()
        // .filter(a -> a.getId() == id)
        // .findFirst();

        for (Actor actor : repo.listActor()) {
            if (actor.getId() == id)
                return Optional.of(actor);
        }
        return Optional.empty();
    }

    @Override
    public List<Actor> listerTousLesActeurs() {

        return repo.listActor();
    }

}
