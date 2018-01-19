package net.hemisoft.ccm.repository;

import java.util.concurrent.CountDownLatch;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.FlushEvent;
import org.hibernate.event.spi.FlushEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateEventListener implements FlushEventListener {
	private static final long serialVersionUID = 1L;

	@Autowired private EntityManagerFactory entityManagerFactory;
	private CountDownLatch latch = new CountDownLatch(0); 
	
	@PostConstruct
    private void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.FLUSH).appendListener(this);
    }

	@Override
	public void onFlush(FlushEvent event) {
		latch.countDown();
	}
	
	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}
}
