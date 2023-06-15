package fr.epsi;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.service.ActorService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        // String param = args[0];
        // Integer paramInt = Integer.parseInt(param);
        // ActorService service = CustomContext.getInstance().getActorService();

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        // ActorService service1 = context.getBean("actorService", ActorService.class);
        // pour pouvoir faire le web service et database en même temps
        ActorService service = context.getBean(ActorService.class);

        List<Actor> actorList = service.listerTousLesActeurs();

        for (Actor actor : actorList) {
            System.out.println(actor);
        }

        int id = 23;
        Optional<Actor> actor = service.getById(id);
        System.out.println("Acteur d'identifiant " + id + " : " + (actor.isPresent() ? actor.get() : "introuvable"));

    }
}
