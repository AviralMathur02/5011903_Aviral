package com.laraib.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final MeterRegistry meterRegistry;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        // Custom counter example
        this.meterRegistry.counter("custom.metric.book.views");
    }

    // Custom methods to increase metrics
    public void incrementBookViews() {
        meterRegistry.counter("custom.metric.book.views").increment();
    }
}

