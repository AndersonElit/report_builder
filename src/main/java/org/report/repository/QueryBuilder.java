package org.report.repository;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface QueryBuilder {
    QueryBuilderImpl reportType(String reportType);
    Uni<List<Object[]>> execute();

}
