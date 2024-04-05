import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TelecommandeTest {

    @Test
    public void testAjouterLampeTelecommandeVide() {
        Telecommande telecommande = new Telecommande();
        Lampe lampe = new Lampe("lampe1");

        telecommande.ajouterLampe(lampe);

        assertEquals(lampe, telecommande.getLampe(0), "La lampe ajoutée devrait être la première lampe dans la télécommande.");
    }

    @Test
    public void testAjouterLampeTelecommandeAvecUnElement() {
        Telecommande telecommande = new Telecommande();
        Lampe lampe1 = new Lampe("lampe1");
        Lampe lampe2 = new Lampe("lampe2");

        telecommande.ajouterLampe(lampe1);
        telecommande.ajouterLampe(lampe2);

        assertEquals(lampe2, telecommande.getLampe(1), "La deuxième lampe ajoutée devrait être à la position 1 dans la télécommande.");
    }

    @Test
    public void testActiverLampeExistantePosition0() {
        Telecommande telecommande = new Telecommande();
        Lampe lampe = new Lampe("lampe1");
        telecommande.ajouterLampe(lampe);

        telecommande.activerLampe(0);

        assertTrue(lampe.isAllume(), "La lampe en position 0 devrait être allumée après activation.");
    }

    @Test
    public void testActiverLampeExistantePosition1() {
        Telecommande telecommande = new Telecommande();
        Lampe lampe1 = new Lampe("lampe1");
        Lampe lampe2 = new Lampe("lampe2");
        telecommande.ajouterLampe(lampe1);
        telecommande.ajouterLampe(lampe2);

        telecommande.activerLampe(1);

        assertTrue(lampe2.isAllume(), "La lampe en position 1 devrait être allumée après activation.");
    }

    @Test
    public void testActiverLampeInexistante() {
        Telecommande telecommande = new Telecommande();
        Lampe lampe = new Lampe("lampe1");
        telecommande.ajouterLampe(lampe);

        assertThrows(IndexOutOfBoundsException.class, () -> telecommande.activerLampe(1), "Une exception devrait être levée lorsque l'on essaie d'activer une lampe inexistante.");
    }
}

