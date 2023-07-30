package edu.jdbctest.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import edu.jdbctest.test.dao.TicketEntityDao;
import edu.jdbctest.test.entity.TicketEntity;

public class DaoRunner {

    public static void main(String[] args) {
        List<TicketEntity> findAll = TicketEntityDao.getInstance().findAll();
        System.out.println(findAll);
    }

    private static void updateTest() {
        TicketEntityDao ticketDao = TicketEntityDao.getInstance();
        Optional<TicketEntity> maybeTicket = ticketDao.findById(2L);
        maybeTicket.ifPresent(ticket -> {
                ticket.setCost(BigDecimal.valueOf(188.88));
        ticketDao.update(ticket);
        });
    }

    private static void getSave() {
        TicketEntityDao ticketDao = TicketEntityDao.getInstance();

        TicketEntity ticketEntity = new TicketEntity();

        ticketEntity.setPassengerNo("12345");
        ticketEntity.setPassengerName("Bob");
        ticketEntity.setFlightId(3L);
        ticketEntity.setSeatNo("B3");
        ticketEntity.setCost(BigDecimal.TEN);
        TicketEntity save = ticketDao.save(ticketEntity);
        System.out.println(save.toString());
    }
}
