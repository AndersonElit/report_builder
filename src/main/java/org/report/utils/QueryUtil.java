package org.report.utils;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;
import org.report.strategy.ParameterStrategy;

import java.util.List;
import java.util.Map;

public class QueryUtil {

    public static Mutiny.Query<Object> buildQuery(Mutiny.Session session1, ParameterStrategy parameterStrategy) {
        Mutiny.Query<Object> query = session1.createNativeQuery(parameterStrategy.getProcedure());
        iterateParameters(query, parameterStrategy.getParameters());
        return query;
    }

    private static void iterateParameters(Mutiny.Query<Object> query, Map<String, Object> parameters) {
        parameters.forEach(query::setParameter);
    }

    public static Uni<List<Object[]>> executeQuery(Mutiny.Query<Object> query) {
        return query.getResultList()
                .onItem()
                .transform(result -> result.stream().map(i -> (Object[]) i)
                        .toList());
    }
}
