import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    @Test
    public void shouldCompare() {
        Ticket soul1 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                100_000,
                6,
                23);
        Ticket soul2 = new Ticket(
                "Москва",
                "Гавана",
                70_000,
                7,
                21);
        Ticket soul3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                10_000,
                21,
                23);
        Ticket soul4 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                7_000,
                7,
                9);
        Ticket soul5 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                15_000,
                20,
                23);
        Ticket soul6 = new Ticket(
                "Москва",
                "Дубай",
                170_000,
                7,
                21);

        Ticket[] tickets = {soul1, soul2, soul3, soul4, soul5, soul6};
        Arrays.sort(tickets);

        Ticket[] expected = {soul4, soul3, soul5, soul2, soul1, soul6};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchSome() {

        Ticket soul1 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                100_000,
                6,
                23);
        Ticket soul2 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                70_000,
                7,
                21);
        Ticket soul3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                10_000,
                21,
                23);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(soul1);
        aviaSouls.add(soul2);
        aviaSouls.add(soul3);

        Ticket[] expected = {soul2, soul1};
        Ticket[] actual = aviaSouls.search("Санкт-Петербург", "Гавана");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOne() {

        Ticket soul1 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                100_000,
                6,
                23);
        Ticket soul2 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                70_000,
                7,
                21);
        Ticket soul3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                10_000,
                21,
                23);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(soul1);
        aviaSouls.add(soul2);
        aviaSouls.add(soul3);

        Ticket[] expected = {soul3};
        Ticket[] actual = aviaSouls.search("Санкт-Петербург", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNone() {

        Ticket soul1 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                100_000,
                6,
                23);
        Ticket soul2 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                70_000,
                7,
                21);
        Ticket soul3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                10_000,
                21,
                23);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(soul1);
        aviaSouls.add(soul2);
        aviaSouls.add(soul3);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Гавана", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFunctionComparator() {

        Ticket soul1 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                100_000,
                6,
                23);
        Ticket soul2 = new Ticket(
                "Москва",
                "Гавана",
                70_000,
                7,
                21);
        Ticket soul3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                10_000,
                20,
                23);
        Ticket soul4 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                7_000,
                7,
                9);
        Ticket soul5 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                15_000,
                19,
                23);
        Ticket soul6 = new Ticket(
                "Москва",
                "Дубай",
                170_000,
                8,
                21);

        Ticket[] tickets = {soul1, soul2, soul3, soul4, soul5, soul6};

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Arrays.sort(tickets, ticketTimeComparator);

        Ticket[] expected = {soul4, soul3, soul5, soul6, soul2, soul1};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchAndSortBySome() {
        Ticket soul1 = new Ticket(
                "Санкт-Петербург",
                "Гавана",
                100_000,
                6,
                23);
        Ticket soul2 = new Ticket(
                "Москва",
                "Гавана",
                70_000,
                7,
                21);
        Ticket soul3 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                10_000,
                20,
                23);
        Ticket soul4 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                7_000,
                7,
                9);
        Ticket soul5 = new Ticket(
                "Санкт-Петербург",
                "Москва",
                15_000,
                19,
                23);
        Ticket soul6 = new Ticket(
                "Москва",
                "Дубай",
                170_000,
                8,
                21);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(soul1);
        aviaSouls.add(soul2);
        aviaSouls.add(soul3);
        aviaSouls.add(soul4);
        aviaSouls.add(soul5);
        aviaSouls.add(soul6);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {soul4, soul3, soul5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Санкт-Петербург", "Москва", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
