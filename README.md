# Gestion des Stages

## Description
Ce projet permet de gérer des stages pour les étudiants, incluant l'ajout de stages, l'affectation d'étudiants à des stages, et la possibilité de filtrer et rechercher des stages par entreprise ou sujet.
## Fonctionnalités

1. **Ajouter un stage**  
   Permet d'ajouter un nouveau stage dans la base de données en renseignant les informations suivantes :  
   - Entreprise  
   - Sujet  
   - Date de début  
   - Date de fin  

2. **Affecter un étudiant**  
   Permet d'affecter un étudiant à un stage spécifique en précisant :  
   - Le stage à affecter  
   - L'étudiant à assigner  
   - L'encadrant responsable du stage  

3. **Filtrer les stages par entreprise**  
   Permet de filtrer et d'afficher tous les stages correspondant à une entreprise donnée.

4. **Rechercher un stage par sujet**  
   Permet de rechercher un ou plusieurs stages par sujet, en affichant tous les stages correspondant à ce critère.

## Tables

1. **Stage**
   - `id` (int) : Identifiant unique du stage
   - `entreprise` (varchar) : Nom de l'entreprise
   - `sujet` (varchar) : Sujet du stage
   - `date_debut` (date) : Date de début du stage
   - `date_fin` (date) : Date de fin du stage

2. **Étudiant**
   - `id` (int) : Identifiant unique de l'étudiant
   - `nom` (varchar) : Nom de l'étudiant
   - `prénom` (varchar) : Prénom de l'étudiant
   - `email` (varchar) : Email de l'étudiant

3. **AffectationStage**
   - `stage_id` (int) : Identifiant du stage
   - `etudiant_id` (int) : Identifiant de l'étudiant affecté
   - `encadrant_id` (int) : Identifiant de l'encadrant
   - `PRIMARY KEY(stage_id, etudiant_id, encadrant_id)`
   - `FOREIGN KEY(stage_id)` : Référence à `Stage(id)`
   - `FOREIGN KEY(etudiant_id)` : Référence à `Etudiant(id)`
   - `FOREIGN KEY(encadrant_id)` : Référence à `Encadrant(id)`

4. **Encadrant**
   - `id` (int) : Identifiant unique de l'encadrant
   - `nom` (varchar) : Nom de l'encadrant
   - `prénom` (varchar) : Prénom de l'encadrant
   - `email` (varchar) : Email de l'encadrant
## Les diagrammes UML:
 ### diagramme des cas d'utilisation :
 ![image](https://github.com/user-attachments/assets/3aef68e0-d15b-4f09-9f4a-4c65d86f3dc9)
 ### diagramme de classe :
 ![image](https://github.com/user-attachments/assets/c4186cd8-7c6d-46b6-a563-bd2adbebdc5c)

## Codes SQL

Voici les requêtes SQL pour créer les tables et insérer des données :

### Création des tables
```sql
CREATE TABLE Encadrant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE Stage (
    id INT PRIMARY KEY AUTO_INCREMENT,
    entreprise VARCHAR(100),
    sujet VARCHAR(100),
    date_debut DATE,
    date_fin DATE
);

CREATE TABLE Etudiant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE AffectationStage (
    stage_id INT NOT NULL,
    etudiant_id INT NOT NULL,
    encadrant_id INT NOT NULL,
    PRIMARY KEY(stage_id, etudiant_id, encadrant_id),
    FOREIGN KEY(stage_id) REFERENCES Stage(id),
    FOREIGN KEY(etudiant_id) REFERENCES Etudiant(id),
    FOREIGN KEY(encadrant_id) REFERENCES Encadrant(id)
);
```
## Technologies utilisées
- **Langage** : Java
- **Framework d'interface graphique** : Java Swing
- **API** : JavaMail
- **Base de données** : MySQL
- **Bibliothèque graphique** : JFreeChart
- **Outils de développement** :
  - IDE : NetBeans
  - Logiciel des diagrammes : MagicDraw
  - Outil de gestion de base de données : phpMyAdmin
- **Accès aux données** : JDBC
## Architecture du projet :
<img width="755" alt="ArchitectureFinal" src="https://github.com/user-attachments/assets/910e43e0-4322-41ba-9c5b-545aa980f90b" />


## Video de test :

https://github.com/user-attachments/assets/852fcca2-afa4-410d-90e4-5b0e4ee352a7

## Video d'installation .exe :

https://github.com/user-attachments/assets/36048f61-b15b-4b5d-b5ed-8fd21d257203









