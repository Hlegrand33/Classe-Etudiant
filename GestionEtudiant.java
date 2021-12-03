import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class GestionEtudiant{
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int nombreEtudiant,choix=0;
     char continuer = 'y' ;
     String nom;
     int age,matricule,moyenne;
     Date date = null;
     Etudiant [] tableau = null;

     System.out.print("entrez ne nombre d'etudiant present a votre cour: ");
     nombreEtudiant = sc.nextInt();
     sc.nextLine();

    tableau = new Etudiant[nombreEtudiant];
    System.out.println();
    System.out.println("-------------------------remplissage des donnees de vos etudiants------------------------------");

   for(int i=0; i<nombreEtudiant; i++){
    System.out.print("entrez le nom de l'etudiant: ");
    nom = sc.nextLine();
    System.out.println();

    System.out.print("entrez age de l'etudiant: ");
    age = sc.nextInt();
    sc.nextLine();
    System.out.println();

    System.out.print("entrez le matricule de l'etudiant: ");
    matricule = sc.nextInt();
    sc.nextLine();
    System.out.println();

    System.out.print("entrez la moyenne de l'etudiant: ");
    moyenne = sc.nextInt();
    sc.nextLine();
    System.out.println();

    date = InitDate(); 
    tableau[i]= new Etudiant(matricule,age,nom,date,moyenne);
  
   }
   System.out.println();
   System.out.println("--------------------------------------------------------");

   do{
       if(continuer == 'y'){
   System.out.println("\t\t Menu D'utilisation");
   System.out.println("\t liste des choix disponibles");
   System.out.println("1-Affichage des Etudiants par ordre de merite");
   System.out.println("2-Afficahge des Information du premier etudiant");
   System.out.println("3-Afficahge des Information du dernier etudiant");
   System.out.println("4-Reinitialiser la liste de la classe");
   System.out.println("5-sotir du programme ");
   System.out.println();
   System.out.print("faites votre choix: ");
   choix = sc.nextInt();

   switch (choix) {
       case 1:
        AffichageParMerite(nombreEtudiant,tableau);
        break;
       case 2:
        AffichagePremier(nombreEtudiant,tableau);
        break;
       case 3:
        AffichageDernier(nombreEtudiant,tableau); 
        break;
        case 4:
         tableau = Reinitialiser();
         break;
        case 5:
         break;
         default:
            System.out.println("choix indisponible");
            break;
        } 
    }
    /*else{ System.out.println("merci d'avoir utliser le programme :=)");
            break;
        }*/
        System.out.println();
        sc.nextLine();
    System.out.print(" voulez vous utiliser une autre fonctionnalite entrez y pour oui et tout autre caratere pour non: ");
    continuer = sc.nextLine().charAt(0);
       
    } while(continuer == 'y');
   
    }

    public static Date InitDate(){
        int mois,jour;
        int annee;
        Scanner sc = new Scanner(System.in);
        Date date = null;
        //System.out.println("");
        System.out.print("entrez le jour de naissance de l'etudiant: ");
       jour = sc.nextInt();
        sc.nextLine();

        System.out.print("entrez le mois de la naissance de l'etudiant: ");
        mois = sc.nextInt();
        sc.nextLine();

        System.out.print("entrez l'anne de la naissance de l'etudiant: ");
        annee = sc.nextInt();
        sc.nextLine();

        date = new Date (annee,mois,jour);
        System.out.println();
        return date;
        
    }

    public static void AffichageParMerite(int taille , Etudiant [] tableau){
        int moyenne ;
        int indice;
        Etudiant tmp;
        for (int i = 0; i <tableau.length; i++) {
            moyenne= tableau[i].GetMoyenne();
            indice = i;
         for(int j = i+1; j <tableau.length; j++) {
            if(tableau[j].GetMoyenne() > moyenne){
                indice=j;
            }
            tmp = tableau[indice];
            tableau[indice]=tableau[i];
            tableau[i]=tmp;
            //moyenne = tableau[i].GetMoyenne();
         }
        }
        System.out.println("affichege des information par ordre de merite");
        for(int k = 0 ; k<tableau.length ; k++){
            tableau[k].afficher();
            System.out.println("--------------------");
        }
    }

    public static void AffichagePremier(int taille , Etudiant [] tableau){
        int moyenne ;
        int indice;
        Etudiant tmp;
        for (int i = 0; i <tableau.length ; i++) {
            moyenne= tableau[i].GetMoyenne();
            indice = i;
         for(int j = i+1; j <tableau.length;j++){
            if(tableau[j].GetMoyenne() > moyenne){
                indice=j;
            }
            tmp = tableau[indice];
            tableau[indice]=tableau[i];
            tableau[i]=tmp;
            //moyenne = tableau[i].GetMoyenne();
         }
        }
        System.out.println("affichege des information par ordre de merite");
            tableau[0].afficher();
        }

        public static void AffichageDernier(int taille , Etudiant [] tableau){
            int moyenne ;
            int indice;
            Etudiant tmp;
            for (int i = 0; i <tableau.length;  i++) {
                moyenne= tableau[i].GetMoyenne();
                indice = i;
             for(int j = i+1; j <tableau.length;j++){
                if(tableau[j].GetMoyenne() > moyenne){
                    indice=j;
                }
                tmp = tableau[indice];
                tableau[indice]=tableau[i];
                tableau[i]=tmp;
                //moyenne = tableau[i].GetMoyenne();
             }
            }
            System.out.println("affichage des information du dernier etudiant");
                tableau[taille-1].afficher();
            }

        public static Etudiant[] Reinitialiser(){
            int nombreEtudiant;
            Scanner sc = new Scanner(System.in);
            Etudiant tableau [] = null;
            String nom;
            int age,matricule,moyenne;
            Date date;

            
            System.out.print("entrez ne nombre d'etudiant present a votre cour: ");
            nombreEtudiant = sc.nextInt();
            sc.nextLine();

             tableau = new Etudiant[nombreEtudiant];

             System.out.println("-------------------------remplissage des donnees de vos etudiants------------------------------");

             for(int i=0; i<nombreEtudiant; i++){
              System.out.print("entrez le nom de l'etudiant: ");
              nom = sc.nextLine();
              System.out.println();
          
              System.out.print("entrez age de l'etudiant: ");
              age = sc.nextInt();
              sc.nextLine();
              System.out.println();
          
              System.out.print("entrez le matricule de l'etudiant: ");
              matricule = sc.nextInt();
              sc.nextLine();
              System.out.println();
          
              System.out.print("entrez la moyenne de l'etudiant: ");
              moyenne = sc.nextInt();
              sc.nextLine();
              System.out.println();
          
              date = InitDate(); 
              tableau[i]= new Etudiant(matricule,age,nom,date,moyenne);
             }
             return tableau;
        }

    

    
}

class Etudiant{
  private  int matricule;
  private  int age ,moyenne ;
  private String nom;
  private Date dateDeNaissance;

    public Etudiant(){
        this.matricule = 0;
        this.age = 0;
        this.nom = "";
        this.dateDeNaissance =null;
    }

    public Etudiant(int matricule, int age, String nom, Date dateDeNaissance , int moyenne){
        this.matricule = matricule;
        this.age = age;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.moyenne = moyenne;
    }

    public void afficher(){
        System.out.println("l'etudiant presant a pour information matricule: "+this.matricule+" age : "+this.age+" nom : "+this.nom+" date de naissance : "+this.dateDeNaissance+" moyenne: " +this.moyenne);
    }

    public void CalculerAge(){
        LocalDateTime date = LocalDateTime.now();
        int age = 0;
        age = date.getYear() - this.dateDeNaissance.getYear();
        System.out.println("l'etudiant est age de "+age);
    }

    public void bonifier(){
        if(this.moyenne >=5 && this.moyenne <= 10){
            System.out.println("le bunus appliquer seras de 5%");
            this.moyenne = (this.moyenne*5)/100 ;
            System.out.println("la moyenne de l'etudiant apres bonus est de " +this.moyenne);
        }
        else if(this.moyenne>=11 && this.moyenne <=20){
            System.out.println("le bunus appliquer seras de 10%");
            this.moyenne = (this.moyenne*10)/100;
            System.out.println("la moyenne de l'etudiant apres bonus est de " +this.moyenne);
        }
        else{
            System.out.println("aucun bonus appliquer") ;
            System.out.println("la moyenne de l'etudiant apres bonus est de " +this.moyenne);}
    }

    public int GetMoyenne(){
        return this.moyenne;
    }
}