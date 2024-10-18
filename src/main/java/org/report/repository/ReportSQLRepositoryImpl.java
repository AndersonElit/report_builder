package org.report.repository;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.reactive.mutiny.Mutiny;

import java.util.List;

@ApplicationScoped
public class ReportSQLRepositoryImpl implements ReportSQLRepository {
    private final Mutiny.SessionFactory session;

    public ReportSQLRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.session = entityManagerFactory.unwrap(Mutiny.SessionFactory.class);
    }

    @Override
    public Uni<List<Object[]>> getData(String reportType) {
        return session.withSession(session1 -> {
            Mutiny.Query<Object> query = session1.createNativeQuery("SELECT * FROM FN_GET_CUSTOMER_INFO(:id, :name, :email, :phone)")
                    .setParameter("id", 30)
                    .setParameter("name", "Charles")
                    .setParameter("email", "charles@hotmail.com")
                    .setParameter("phone", "123456789");

            return query.getResultList()
                    .onItem()
                    .transform(result -> result.stream().map(i -> (Object[]) i)
                            .toList());

                });
    }

}
