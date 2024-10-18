package org.report.context;

import org.report.strategy.ParameterStrategy;
import org.report.strategy.impl.CustomerParameters;

import java.util.HashMap;
import java.util.Map;

public class ParameterContext {
    private final Map<String, ParameterStrategy> strategies = new HashMap<>();

    public ParameterContext() {
        strategies.put("CUSTOMER_REPORT", new CustomerParameters());
    }

    public ParameterStrategy getStrategy(String reportType) {
        return strategies.get(reportType);
    }

}
