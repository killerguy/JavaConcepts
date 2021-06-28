package com.mukul.snippets.circuitbreaker;

import io.vavr.collection.Seq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.util.List;

public class CircuitBreakerService {
    private static final Integer secondsToStoreMetrics = 604800;
    private static final CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
            .slidingWindowSize(secondsToStoreMetrics)
            .build();
    private static final CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerService.class);


    public static CircuitBreaker getCircuitBreaker(String identifier) {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(identifier);
        circuitBreaker.getEventPublisher().onStateTransition(event -> logger.info(
                String.format("The circuit %s has transitioned to state %s",
                        circuitBreaker.getName(),
                        event.getStateTransition())));
        return circuitBreaker;
    }

    public static void resetCircuitBreaker(String circuitBreakerName) {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(circuitBreakerName);
        circuitBreaker.reset();
    }

    public static void resetAllCircuitBreakers() {
        Seq<CircuitBreaker> circuitBreakers = circuitBreakerRegistry.getAllCircuitBreakers();
        circuitBreakers.forEach(CircuitBreaker::reset);
    }

    public static List<CircuitBreaker> getAllCircuitBreakers() {
        return circuitBreakerRegistry.getAllCircuitBreakers().toJavaList();
    }
}
