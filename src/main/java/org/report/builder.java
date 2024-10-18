package org.report;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.report.repository.ReportSQLRepository;

@Path("/build")
@RequiredArgsConstructor
public class builder {

    private final ReportSQLRepository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {

        return repository.getData("report")
                .invoke(list -> list.forEach(e -> {
                    for (int i = 0; i < e.length; i++) {
                        System.out.println(e[i].toString());
                    }
                })).map(list -> list.toString());
    }
}
