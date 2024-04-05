import java.util.ArrayList;
import java.util.List;

public class Telecommande {
    private List<Lampe> lampes;

    public Telecommande() {
        this.lampes = new ArrayList<>();
    }

    public void ajouterLampe(Lampe nouvelleLampe) {
        this.lampes.add(nouvelleLampe);
    }

    public void activerLampe(int indiceLampe) {
        if (indiceLampe >= 0 && indiceLampe < lampes.size()) {
            lampes.get(indiceLampe).allumer();
        } else {
            throw new IndexOutOfBoundsException("La lampe à l'indice spécifié n'existe pas.");
        }
    }

    public void desactiverLampe(int indiceLampe) {
        if (indiceLampe >= 0 && indiceLampe < lampes.size()) {
            lampes.get(indiceLampe).eteindre();
        } else {
            throw new IndexOutOfBoundsException("La lampe à l'indice spécifié n'existe pas.");
        }
    }

    public void activerTout() {
        for (Lampe lampe : lampes) {
            lampe.allumer();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lampes.size(); i++) {
            stringBuilder.append("Lampe ").append(i).append(": ").append(lampes.get(i).toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public Lampe getLampe(int indiceLampe) {
        if (indiceLampe >= 0 && indiceLampe < lampes.size()) {
            return lampes.get(indiceLampe);
        } else {
            throw new IndexOutOfBoundsException("La lampe à l'indice spécifié n'existe pas.");
        }
    }
}

