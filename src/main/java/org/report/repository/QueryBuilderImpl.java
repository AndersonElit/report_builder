package org.report.repository;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.reactive.mutiny.Mutiny;
import org.report.context.ParameterContext;
import org.report.strategy.ParameterStrategy;

import java.util.List;
import java.util.Map;

import static org.report.utils.QueryUtil.buildQuery;
import static org.report.utils.QueryUtil.executeQuery;

@ApplicationScoped
public class QueryBuilderImpl implements QueryBuilder {
    private final Mutiny.SessionFactory session;
    private ParameterStrategy parameterStrategy;

    public QueryBuilderImpl(EntityManagerFactory entityManagerFactory) {
        this.session = entityManagerFactory.unwrap(Mutiny.SessionFactory.class);
    }

    @Override
    public QueryBuilderImpl reportType(String reportType) {
        ParameterContext parameterContext = new ParameterContext();
        this.parameterStrategy = parameterContext.getStrategy(reportType);
        return this;
    }

    @Override
    public Uni<List<Object[]>> execute() {
        return session.withSession(session1 -> {
            Mutiny.Query<Object> query = buildQuery(session1, parameterStrategy);
            return executeQuery(query);
        });
    }

}
