package com.project.ipb.ipbProject.hibernateTools;

import com.project.ipb.ipbProject.model.Application;
import com.project.ipb.ipbProject.model.Estimate;
import org.hibernate.Session;

import java.util.List;
import java.util.logging.Logger;

/**
 * A class containing database connection functions
 */
public class HibernateDBUtil {

    public static Estimate getEstimate(long Id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from estimate es where es.id = :estimateId", Estimate.class).
                    setParameter("estimateId", Id).list().get(0);
        }
    }

    public static List<Estimate> getEstimates() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from estimate ", Estimate.class).list();
        }
    }

    public static void insertApplication(Application application){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(application);
            session.getTransaction().commit();
        }
    }

    public static Application getApplication(long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from application ap where ap.id = :applicationId", Application.class).
                    setParameter("applicationId", id).list().get(0);
        }
    }
}
