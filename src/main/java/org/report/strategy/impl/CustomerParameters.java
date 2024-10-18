package org.report.strategy.impl;

import org.report.ParamsBuilder;
import org.report.strategy.ParameterStrategy;

import java.util.Map;

public class CustomerParameters implements ParameterStrategy {

    @Override
    public Map<String, Object> getParameters() {
        return new ParamsBuilder()
                    .add("id", 200)
                    .add("name", "andres")
                    .add("email", "andres@gmail.com")
                    .add("phone", "123456789")
                .build();
    }

    @Override
    public String getProcedure() {
        return "SELECT * FROM FN_GET_CUSTOMER_INFO(:id, :name, :email, :phone)";
    }

}
