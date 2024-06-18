package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {


    @Test
    public void shouldComparePrice() {
        Ticket price1 = new Ticket("MSK", "SPB", 12_000, 14, 17);
        Ticket price2 = new Ticket("MSK", "SPB", 7_000, 17, 19);
        AviaSouls aviaSouls = new AviaSouls();


        aviaSouls.add(price1);
        aviaSouls.add(price2);


        int expected = 1;
        int actual = price1.compareTo(price2);

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldSortFewTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 12_500, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 7_500, 6, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_500, 8, 10);
        Ticket ticket4 = new Ticket("MSK", "SPB", 11_500, 9, 11);
        Ticket ticket5 = new Ticket("MSK", "SPB", 9_500, 12, 14);
        Ticket ticket6 = new Ticket("NEW", "LA", 6_500, 4, 19);
        Ticket ticket7 = new Ticket("MSK", "SPB", 13_500, 8, 10);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_500, 12, 14);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);


        Ticket[] actual = aviaSouls.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket3, ticket8, ticket5, ticket4, ticket1, ticket7};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 12_500, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 7_500, 6, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_500, 8, 10);
        Ticket ticket4 = new Ticket("MSK", "SPB", 11_500, 9, 11);
        Ticket ticket5 = new Ticket("MSK", "SPB", 9_500, 12, 14);
        Ticket ticket6 = new Ticket("NEW", "LA", 6_500, 4, 19);
        Ticket ticket7 = new Ticket("MSK", "SPB", 13_500, 8, 10);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_500, 12, 14);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);


        Ticket[] actual = aviaSouls.search("NEW", "LA");
        Ticket[] expected = { ticket6};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNoTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 12_500, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 7_500, 6, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_500, 8, 10);
        Ticket ticket4 = new Ticket("MSK", "SPB", 11_500, 9, 11);
        Ticket ticket5 = new Ticket("MSK", "SPB", 9_500, 12, 14);
        Ticket ticket6 = new Ticket("NEW", "LA", 6_500, 4, 19);
        Ticket ticket7 = new Ticket("MSK", "SPB", 13_500, 8, 10);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_500, 12, 14);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);


        Ticket[] actual = aviaSouls.search("NEW", "SPB");
        Ticket[] expected = {};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketWithComparatorIfFewTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 12_500, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 7_500, 6, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_500, 8, 14);
        Ticket ticket4 = new Ticket("MSK", "SPB", 11_500, 9, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 9_500, 12, 19);
        Ticket ticket6 = new Ticket("NEW", "LA", 6_500, 4, 19);
        Ticket ticket7 = new Ticket("MSK", "SPB", 13_500, 8, 9);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_500, 12, 14);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);


        Ticket[] actual = aviaSouls.searchAndSortBy("MSK", "SPB", timeComparator);
        Ticket[] expected = {ticket7, ticket1, ticket8, ticket2, ticket3, ticket4, ticket5};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketWithComparatorIfOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 12_500, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 7_500, 6, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_500, 8, 14);
        Ticket ticket4 = new Ticket("MSK", "SPB", 11_500, 9, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 9_500, 12, 19);
        Ticket ticket6 = new Ticket("NEW", "LA", 6_500, 4, 19);
        Ticket ticket7 = new Ticket("MSK", "SPB", 13_500, 8, 9);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_500, 12, 14);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);


        Ticket[] actual = aviaSouls.searchAndSortBy("NEW", "LA", timeComparator);
        Ticket[] expected = {ticket6};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketWithComparatorIfNoTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 12_500, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 7_500, 6, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_500, 8, 14);
        Ticket ticket4 = new Ticket("MSK", "SPB", 11_500, 9, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 9_500, 12, 19);
        Ticket ticket6 = new Ticket("NEW", "LA", 6_500, 4, 19);
        Ticket ticket7 = new Ticket("MSK", "SPB", 13_500, 8, 9);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_500, 12, 14);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);


        Ticket[] actual = aviaSouls.searchAndSortBy("NEW", "MSK", timeComparator);
        Ticket[] expected = {};


        Assertions.assertArrayEquals(expected, actual);
    }






}



