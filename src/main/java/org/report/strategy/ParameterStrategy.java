package org.report.strategy;

import java.util.Map;

public interface ParameterStrategy {
    Map<String, Object> getParameters();
    String getProcedure();
}
