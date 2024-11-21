# TaskManager

TaskManager est une application Android simple et intuitive permettant aux utilisateurs de gérer leurs tâches quotidiennes. Elle propose des fonctionnalités de création, visualisation et rappel des tâches pour améliorer la productivité.

## Auteurs
LEROGNON Grégoire
MESSIA DOLIVEUX Lucas
YAZI Iles

## Fonctionnalités

- **Liste des tâches** : Visualisez toutes vos tâches organisées dans une liste.
- **Marquage des tâches** : Marquez une tâche comme terminée grâce à une case à cocher.
- **Rappels de tâches** : Recevez des notifications pour vos tâches importantes.
- **Interface utilisateur intuitive** : Naviguez facilement grâce à une interface propre et simple.
- **Extensible** : Ajoutez ou améliorez facilement les fonctionnalités.


## Structure du Projet

### Fichiers Principaux

| Fichier                 | Description                                                  |
|-------------------------|--------------------------------------------------------------|
| `MainActivity.kt`       | Activité principale qui affiche la liste des tâches.         |
| `TaskAdapter.kt`        | Adaptateur pour connecter les données au RecyclerView.       |
| `ReminderService.kt`    | Service en arrière-plan pour gérer les rappels.              |
| `AlarmReceiver.kt`      | BroadcastReceiver pour recevoir les alarmes de rappels.      |
| `activity_main.xml`     | Mise en page de l'écran principal.                           |
| `item_task.xml`         | Mise en page des éléments individuels dans la liste.         |

### Fonctionnalités Techniques
- Utilisation d'un **RecyclerView** pour une liste dynamique.
- Gestion des tâches avec un **Adapter** personnalisé.
- Implémentation d'un **Service** pour les notifications de rappel.
- Intégration d'un **BroadcastReceiver** pour déclencher des rappels.

## Installation

### Prérequis

- Android Studio installé sur votre machine.
- Appareil Android ou émulateur pour tester l'application.

### Étapes

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/votre-utilisateur/taskmanager.git
   ```
2. Ouvrez le projet dans Android Studio.
3. Synchronisez les dépendances Gradle.
4. Lancez l'application sur un émulateur ou un appareil réel.

## Utilisation

1. **Lancer l'application** : Ouvrez l'application pour voir la liste des tâches prédéfinies.
2. **Ajouter une tâche** : Implémentez un bouton d'ajout dans des versions ultérieures.
3. **Recevoir un rappel** : Configurez une tâche avec un rappel pour recevoir une notification.

