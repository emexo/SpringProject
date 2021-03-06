package com.emexo.webclient;

import com.emexo.entity.Application;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebClientExample {

    public static void main(String[] args) {
        WebClientExample obj = new WebClientExample();
        //obj.findAllApplications();
        //obj.findApplicationById();
        obj.createApplication();
    }

    public void findAllApplications() {
        WebClient webClient = WebClient.create("http://localhost:8080/application/getAll");
        Flux<Application> result = webClient.get()
                .retrieve()
                .bodyToFlux(Application.class);
        System.out.println("RESPONSE : " + result.collectList().block());
    }

    public void findApplicationById() {
        WebClient webClient = WebClient.create("http://localhost:8080/tza/application/1");
        Mono<Application> response = webClient.get()
                .retrieve()
                .bodyToMono(Application.class);

        System.out.println("RESPONSE : " + response.block());
    }

    public void createApplication() {
        Application app = new Application();
        app.setDescription("LRI");
        app.setName("LRI");
        app.setOwner("JPMC");
        WebClient webClient = WebClient.create("http://localhost:8080/application/save");
        Mono<Application> response = webClient.post()
                .body(Mono.just(app), Application.class)
                .retrieve()
                .bodyToMono(Application.class);
        response.block();
    }

    public void updateApplication() {
        Application app = new Application();
        app.setId(1L);
        app.setDescription("LRI");
        app.setName("LRI");
        app.setOwner("JPMC");
        WebClient webClient = WebClient.create("http://localhost:8080/tza/applicationupdate");
        Mono<Application> response = webClient.put()
                .body(Mono.just(app), Application.class)
                .retrieve()
                .bodyToMono(Application.class);
    }

    public void deleteApplication() {
        WebClient webClient = WebClient.create("http://localhost:8080/tza/applicatiodelete/1");
        Mono<Void> response = webClient.delete()
                .retrieve()
                .bodyToMono(void.class);

    }

}
