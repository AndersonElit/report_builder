package org.report.repository;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ReportSQLRepository {
    Uni<List<Object[]>> getData(String reportType);

}
