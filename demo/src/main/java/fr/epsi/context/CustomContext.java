package fr.epsi.context;

import fr.epsi.actor.repository.ActorRepository;
import fr.epsi.actor.repository.WebserviceRepository;
import fr.epsi.actor.service.ActorService;
import fr.epsi.actor.service.MyActorService;

public class CustomContext {

    private static CustomContext instance = new CustomContext();

    private ActorService actorService;

    private CustomContext() {
        ActorRepository repository = new WebserviceRepository();
        actorService = new MyActorService(repository);
    }

    public static CustomContext getInstance() {
        return instance;
    }

    public ActorService getActorService() {
        return actorService;
    }
}
