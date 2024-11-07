import java.util.Scanner;

// Classe Champion para representar um campeão
class Champion {
    private String name;
    private int life;
    private final int attack;
    private final int armor;
    
    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }
    
    public void takeDamage(Champion attacker) {
        int damage = Math.max(1, attacker.attack - this.armor);
        this.life = Math.max(0, this.life - damage);
    }
    
    public String status() {
        if (this.life == 0) {
            return this.name + ": " + this.life + " de vida (morreu)";
        }
        return this.name + ": " + this.life + " de vida";
    }
    
    public boolean isAlive() {
        return this.life > 0;
    }
}

// Classe principal com o programa
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Leitura dos dados do primeiro campeão
        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String name1 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life1 = sc.nextInt();
        System.out.print("Ataque: ");
        int attack1 = sc.nextInt();
        System.out.print("Armadura: ");
        int armor1 = sc.nextInt();
        
        sc.nextLine(); // Consumir quebra de linha pendente
        
        // Leitura dos dados do segundo campeão
        System.out.println("Digite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String name2 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life2 = sc.nextInt();
        System.out.print("Ataque: ");
        int attack2 = sc.nextInt();
        System.out.print("Armadura: ");
        int armor2 = sc.nextInt();
        
        // Criação dos campeões
        Champion champion1 = new Champion(name1, life1, attack1, armor1);
        Champion champion2 = new Champion(name2, life2, attack2, armor2);
        
        // Leitura do número de turnos
        System.out.print("Quantos turnos você deseja executar? ");
        int n = sc.nextInt();
        
        // Execução dos turnos
        for (int i = 1; i <= n && champion1.isAlive() && champion2.isAlive(); i++) {
            // Ambos os campeões se atacam
            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);
            
            // Mostra o resultado do turno
            System.out.println("Resultado do turno " + i + ":");
            System.out.println(champion1.status());
            System.out.println(champion2.status());
        }
        
        System.out.println("### FIM DO COMBATE ###");
        
        sc.close();
    }
}