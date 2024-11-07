import java.util.Scanner;

class Campeao {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    public Campeao(String nome, int vida, int ataque, int armadura) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public void takeDamage(int dano) {
        int danoRecebido = Math.max(1, dano - this.armadura);
        this.vida = Math.max(0, this.vida - danoRecebido);
    }

    public String status() {
        return this.vida > 0 ? this.nome + ": " + this.vida + " de vida" : this.nome + ": 0 de vida (morreu)";
    }

    public int getAtaque() {
        return this.ataque;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }
}

public class Combate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String nome1 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int vida1 = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque1 = sc.nextInt();
        System.out.print("Armadura: ");
        int armadura1 = sc.nextInt();

        System.out.println("Digite os dados do segundo campeão:");
        sc.nextLine(); // Consumir o resto da linha
        System.out.print("Nome: ");
        String nome2 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int vida2 = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque2 = sc.nextInt();
        System.out.print("Armadura: ");
        int armadura2 = sc.nextInt();

        System.out.print("Quantos turnos você deseja executar? ");
        int turnos = sc.nextInt();

        Campeao campeao1 = new Campeao(nome1, vida1, ataque1, armadura1);
        Campeao campeao2 = new Campeao(nome2, vida2, ataque2, armadura2);

        for (int i = 1; i <= turnos; i++) {
            if (!campeao1.estaVivo() || !campeao2.estaVivo()) {
                break;
            }

            campeao1.takeDamage(campeao2.getAtaque());
            campeao2.takeDamage(campeao1.getAtaque());

            System.out.println("Resultado do turno " + i + ":");
            System.out.println(campeao1.status());
            System.out.println(campeao2.status());
        }

        System.out.println("\n### FIM DO COMBATE ###");
        sc.close();
    }
}
