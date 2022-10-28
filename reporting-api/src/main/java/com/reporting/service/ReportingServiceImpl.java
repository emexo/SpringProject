package com.reporting.service;

import com.reporting.controller.ReportingController;
import com.reporting.model.ApplicationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService{

    private static final Logger LOGGER= LoggerFactory.getLogger(ReportingServiceImpl.class);

    @Value("${application.url.getall}")
    private String applicationGetAllUrl;

    @Override
    public List<ApplicationVO> findAll() {
        LOGGER.info("Inside ReportingServiceImpl.findAll, and applicationGetAllUrl:{}",applicationGetAllUrl );

        WebClient webClient = WebClient.create(applicationGetAllUrl);
        Flux<ApplicationVO> result = webClient.get()
                .retrieve()
                .bodyToFlux(ApplicationVO.class);
        return result.collectList().block();
    }

    @Override
    public ApplicationVO findById(long id) {
        LOGGER.info("Inside ReportingServiceImpl.findAll, and applicationGetAllUrl:{}",applicationGetAllUrl );

        WebClient webClient = WebClient.create(applicationGetAllUrl+"/"+id);
        Mono<ApplicationVO> result = webClient.get()
                .retrieve()
                .bodyToMono(ApplicationVO.class);
        return result.block();
    }
}
