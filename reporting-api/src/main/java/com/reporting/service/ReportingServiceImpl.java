package com.reporting.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reporting.model.ApplicationRequest;
import com.reporting.model.ApplicationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService{

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOGGER= LoggerFactory.getLogger(ReportingServiceImpl.class);

    @Value("${application.url}")
    private String applicationUrl;


    public List<ApplicationVO> findAllNew() throws JsonProcessingException {
        LOGGER.info("Inside ReportingServiceImpl.findAll, and applicationGetAllUrl:{}",applicationUrl );

        ResponseEntity<ApplicationVO[]> response = restTemplate.getForEntity(applicationUrl, ApplicationVO[].class);
        ApplicationVO[] applicationArray = response.getBody();
        return Arrays.asList(applicationArray);
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
