package fr.epsi.actor.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.epsi.actor.model.Actor;

public class WebserviceRepository implements ActorRepository {

    @Override
    public List<Actor> listActor() {

        List<Actor> actorList = new ArrayList<>();

        String url = "https://63481ec00484786c6e926453.mockapi.io/api/v1/actors";
        String body = null;

        // Récupération du contenu JSON via HTTP
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest req = HttpRequest.newBuilder(URI.create(url)).build();
        try {
            body = client.send(req, BodyHandlers.ofString()).body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mapping JSON vers Object Métier
        ObjectMapper mapper = new ObjectMapper();
        try {
            actorList = mapper.readerForListOf(Actor.class).readValue(body);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return actorList;
    }

}
