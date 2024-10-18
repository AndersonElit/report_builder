package org.report;

import java.util.HashMap;
import java.util.Map;

public class ParamsBuilder {
    private Map<String, Object> parameters = new HashMap<>();

    public ParamsBuilder add(String key, Object value) {
        parameters.put(key, value);
        return this;
    }

    public Map<String, Object> build() {
        return parameters;
    }
}
