package fr.epsi.actor.web;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.service.ActorService;
import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActorControler extends AbstractController {

    private ActorService service;

    @Override
    @Nullable
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Actor> actors = service.listerTousLesActeurs();
        var view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        view.setExtractValueFromSingleKeyModel(true);
        return new ModelAndView(view, "actors", actors);
    }
}
