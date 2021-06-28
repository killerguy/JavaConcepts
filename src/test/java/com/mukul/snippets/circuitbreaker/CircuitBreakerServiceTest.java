package com.mukul.snippets.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class CircuitBreakerServiceTest {
    private final String CIRCUIT_BREAKER_NAME = "FLKDSJH";

    @Before
    public void setUp() {
        CircuitBreakerService.resetAllCircuitBreakers();
    }

    @After
    public void teardown() {
        CircuitBreakerService.resetAllCircuitBreakers();
    }

    @Test
    public void should_reset_all_circuit_breakers() {
        CircuitBreaker circuitBreaker1 = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        CircuitBreaker circuitBreaker2 = CircuitBreakerService.getCircuitBreaker("ODPENV");
        setCircuitInHalfOpenState(circuitBreaker1);
        setCircuitInHalfOpenState(circuitBreaker2);

        CircuitBreakerService.resetAllCircuitBreakers();

        assertEquals(CircuitBreaker.State.CLOSED, circuitBreaker1.getState());
        assertEquals(CircuitBreaker.State.CLOSED, circuitBreaker2.getState());
    }

    @Test
    public void should_reset_one_circuit_breaker() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        setCircuitInHalfOpenState(circuitBreaker);

        CircuitBreakerService.resetCircuitBreaker(circuitBreaker.getName());

        assertEquals(CircuitBreaker.State.CLOSED, circuitBreaker.getState());
    }

    @Test
    public void should_get_requested_circuit_breaker() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);

        assertEquals(CIRCUIT_BREAKER_NAME, circuitBreaker.getName());
    }

    @Test
    public void should_default_to_closed_state() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);

        assertEquals(CircuitBreaker.State.CLOSED, circuitBreaker.getState());
    }

    @Test
    public void should_not_transition_to_open_state_until_at_least_100_requests() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Integer numberOfFailingRequests = 99;
        Integer numberOfSuccessfulRequests = 0;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);

        assertEquals(CircuitBreaker.State.CLOSED, circuitBreaker.getState());
    }

    @Test
    public void should_transition_to_open_state_after_100_failing_requests() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Integer numberOfFailingRequests = 100;
        Integer numberOfSuccessfulRequests = 0;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);

        assertEquals(CircuitBreaker.State.OPEN, circuitBreaker.getState());
    }

    @Test
    public void should_stay_in_closed_state_when_failure_rate_is_less_than_50() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Integer numberOfFailingRequests = 49;
        Integer numberOfSuccessfulRequests = 51;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);

        assertEquals(CircuitBreaker.State.CLOSED, circuitBreaker.getState());
    }

    @Test
    public void should_transition_to_open_state_when_failure_rate_is_at_least_50() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Integer numberOfFailingRequests = 50;
        Integer numberOfSuccessfulRequests = 50;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);

        assertEquals(CircuitBreaker.State.OPEN, circuitBreaker.getState());
    }

    @Test
    public void should_wait_60_seconds_in_open_state() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Long expectedWaitTimeInOpenState = 60000L;

        Long configuredWaitTimeInOpenState = circuitBreaker.getCircuitBreakerConfig().getWaitIntervalFunctionInOpenState().apply(1);

        assertEquals(expectedWaitTimeInOpenState, configuredWaitTimeInOpenState);
    }

    @Test
    public void should_wait_60_seconds_in_slow_call_duration_threshold() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Long expectedWaitTimeInOpenState = 60L;

        Long configuredWaitTimeInOpenState = circuitBreaker.getCircuitBreakerConfig().getSlowCallDurationThreshold().getSeconds();

        assertEquals(expectedWaitTimeInOpenState, configuredWaitTimeInOpenState);
    }

    @Test
    public void should_have_slow_call_rate_threshold_of_100() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Float expectedSlowCallRateThreshold = 100f;

        Float configuredSlowCallRateThreshold = circuitBreaker.getCircuitBreakerConfig().getSlowCallRateThreshold();

        assertEquals(expectedSlowCallRateThreshold, configuredSlowCallRateThreshold);
    }

    @Test
    public void should_transition_to_closed_state_after_10_requests_not_exceeding_failure_threshold() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        setCircuitInHalfOpenState(circuitBreaker);
        Integer numberOfFailingRequests = 4;    // failure threshold is implicitly assumed to be 50%
        Integer numberOfSuccessfulRequests = 6;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);

        assertEquals(CircuitBreaker.State.CLOSED, circuitBreaker.getState());
    }

    @Test
    public void should_transition_back_to_open_state_after_10_requests_exceed_failure_threshold() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        setCircuitInHalfOpenState(circuitBreaker);
        Integer numberOfFailingRequests = 5;    // failure threshold is implicitly assumed to be 50%
        Integer numberOfSuccessfulRequests = 5;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);

        assertEquals(CircuitBreaker.State.OPEN, circuitBreaker.getState());
    }

    @Test
    public void should_have_time_based_sliding_window_type() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        CircuitBreakerConfig.SlidingWindowType expectedSlidingWindowType = CircuitBreakerConfig.SlidingWindowType.TIME_BASED;

        CircuitBreakerConfig.SlidingWindowType configuredSlidingWindowType = circuitBreaker.getCircuitBreakerConfig().getSlidingWindowType();

        assertEquals(expectedSlidingWindowType, configuredSlidingWindowType);
    }

    @Test
    public void should_have_sliding_window_size_of_100() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Integer expectedSlidingWindowSize = 604800;

        Integer actualSlidingWindowSize = circuitBreaker.getCircuitBreakerConfig().getSlidingWindowSize();

        assertEquals(expectedSlidingWindowSize, actualSlidingWindowSize);
    }

    @Test
    public void should_count_number_of_failing_requests() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Integer numberOfFailingRequests = 100;
        Integer numberOfSuccessfulRequests = 0;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);

        assertEquals(numberOfFailingRequests, (Integer) circuitBreaker.getMetrics().getNumberOfFailedCalls());
    }

    @Test
    public void should_count_number_of_requests() {
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        Integer numberOfFailingRequests = 10;
        Integer numberOfSuccessfulRequests = 505;
        CircuitBreaker.Metrics metrics = circuitBreaker.getMetrics();
        Integer expectedNumberOfRequests = numberOfFailingRequests + numberOfSuccessfulRequests;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);
        Integer actualNumberOfRequests = metrics.getNumberOfSuccessfulCalls() + metrics.getNumberOfFailedCalls();

        assertEquals(expectedNumberOfRequests, actualNumberOfRequests);
    }

    private void setCircuitInHalfOpenState(CircuitBreaker circuitBreaker) {
        CircuitBreaker.State circuitState = circuitBreaker.getState();

        if (circuitState == CircuitBreaker.State.CLOSED) {
            circuitBreaker.transitionToOpenState();
            circuitBreaker.transitionToHalfOpenState();
        } else if (circuitState == CircuitBreaker.State.OPEN) {
            circuitBreaker.transitionToHalfOpenState();
        }
    }

    private void executeRequests(CircuitBreaker circuitBreaker, Integer numberOfFailingRequests, Integer numberOfSuccessfulRequests) {
        Supplier<String> failingSupplier = () -> {
            throw new RuntimeException("BAM!");
        };
        Supplier<String> SuccessfulSupplier = () -> "success";

        for(int i=0; i < numberOfFailingRequests; i++){
            try {
                circuitBreaker.executeSupplier(failingSupplier);
            } catch(Exception e) {
                // do nothing
            }
        }
        for(int i=0; i < numberOfSuccessfulRequests; i++){
            circuitBreaker.executeSupplier(SuccessfulSupplier);
        }
    }

    @Test
    public void should_get_all_circuit_name(){
        System.out.println("Empty "+CircuitBreakerService.getAllCircuitBreakers());
        CircuitBreaker circuitBreaker = CircuitBreakerService.getCircuitBreaker(CIRCUIT_BREAKER_NAME);
        int numberOfFailingRequests =0;
        int numberOfSuccessfulRequests = 5;

        executeRequests(circuitBreaker, numberOfFailingRequests, numberOfSuccessfulRequests);
        System.out.println(CircuitBreakerService.getAllCircuitBreakers());
    }
}

