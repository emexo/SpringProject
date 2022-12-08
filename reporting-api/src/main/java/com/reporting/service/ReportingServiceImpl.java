package com.reporting.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reporting.model.ApplicationRequest;
import com.reporting.model.ApplicationVO;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@EnableRetry
@Service
public class ReportingServiceImpl implements ReportingService{

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOGGER= LoggerFactory.getLogger(ReportingServiceImpl.class);

    @Value("${application.url}")
    private String applicationUrl;

    @Retryable(value = {Exception.class}, maxAttempts = 5, backoff = @Backoff(delay = 6000))
    public List<ApplicationVO> findAllNew() throws Exception {
        LOGGER.info("Inside ReportingServiceImpl.findAll, and applicationGetAllUrl:{}",applicationUrl );
        URI uri = new URI(applicationUrl);

        ResponseEntity<ApplicationVO[]> response = restTemplate.getForEntity(uri, ApplicationVO[].class);
        ApplicationVO[] applicationArray = response.getBody();
        return Arrays.asList(applicationArray);
    }

    @Recover
    public List<ApplicationVO> recover(Exception ex){
        System.out.println("##########Recover##########");
        return null;
    }

    @Override
    public List<ApplicationVO> findAll() {
        LOGGER.info("Inside ReportingServiceImpl.findAll, and applicationGetAllUrl:{}",applicationUrl );

        WebClient webClient = WebClient.create(applicationUrl);
        Flux<ApplicationVO> result = webClient.get()
                .retrieve()
                .bodyToFlux(ApplicationVO.class);
        return result.collectList().block();
    }

    @Override
    public ApplicationVO findById(long id) {
        LOGGER.info("Inside ReportingServiceImpl.findAll, and applicationGetAllUrl:{}",applicationUrl );

        WebClient webClient = WebClient.create(applicationUrl+"/"+id);
        Mono<ApplicationVO> result = webClient.get()
                .retrieve()
                .bodyToMono(ApplicationVO.class);
        return result.block();
    }

    /**
     * Invoke bug tracking api post end point
     * @param request
     * @return
     */
    public ApplicationVO save(ApplicationRequest request){
        LOGGER.info("Inside ReportingServiceIm.save, request:{}", request);
        WebClient webClient = WebClient.create(applicationUrl);

        Mono<ApplicationVO> response = webClient.post()
                .body(Mono.just(request), ApplicationRequest.class)
                .retrieve()
                .bodyToMono(ApplicationVO.class);
        return response.block();
    }

    public ApplicationVO saveNew(ApplicationRequest request) throws URISyntaxException {
        LOGGER.info("Inside ApplicationServiceImpl.saveNew, request:{}", request);

        URI uri = new URI(applicationUrl);

        LOGGER.info("Application url to save the application:{}", applicationUrl);
        HttpHeaders header=new HttpHeaders();
        HttpEntity<ApplicationRequest> entity=new HttpEntity<ApplicationRequest>(request, header);

        ResponseEntity<ApplicationVO> response=restTemplate.postForEntity(uri, entity, ApplicationVO.class);
        LOGGER.info("Response from application save, status code :{} and data:{}" , response.getStatusCode(), response.getBody());
        return response.getBody();
    }

    public void updateNew(ApplicationRequest request) throws URISyntaxException {
        LOGGER.info("Inside ApplicationServiceImpl.saveNew, request:{}", request);

        URI uri = new URI(applicationUrl);

        LOGGER.info("Application url to save the application:{}", applicationUrl);
        HttpHeaders header=new HttpHeaders();
        HttpEntity<ApplicationRequest> entity=new HttpEntity<ApplicationRequest>(request, header);
        restTemplate.put(uri, entity);

    }

    public ApplicationVO update(ApplicationRequest request){
        LOGGER.info("Inside ReportingServiceIm.save, request:{}", request);
        WebClient webClient = WebClient.create(applicationUrl);

        Mono<ApplicationVO> response = webClient.put()
                .body(Mono.just(request), ApplicationRequest.class)
                .retrieve()
                .bodyToMono(ApplicationVO.class);
        return response.block();
    }
}
