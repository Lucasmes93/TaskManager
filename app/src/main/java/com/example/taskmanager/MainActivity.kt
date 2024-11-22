package com.example.taskmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private val tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation du RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewTasks)
        taskAdapter = TaskAdapter(tasks) { position -> deleteTask(position) }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        // Bouton pour ajouter une tâche
        val addTaskButton = findViewById<Button>(R.id.addTaskButton)
        val taskInput = findViewById<EditText>(R.id.taskInput)

        addTaskButton.setOnClickListener {
            val newTask = taskInput.text.toString()
            if (newTask.isNotBlank()) {
                addTask(newTask)
                taskInput.text.clear()
            } else {
                Toast.makeText(this, "Veuillez entrer une tâche", Toast.LENGTH_SHORT).show()
            }
        }

        createNotificationChannel()
    }

    private fun addTask(task: String) {
        tasks.add(task)
        taskAdapter.notifyItemInserted(tasks.size - 1)
        sendNotification("Nouvelle tâche ajoutée", "Tâche : $task")
    }

    private fun deleteTask(position: Int) {
        val removedTask = tasks[position]
        tasks.removeAt(position)
        taskAdapter.notifyItemRemoved(position)
        Toast.makeText(this, "Tâche supprimée : $removedTask", Toast.LENGTH_SHORT).show()
    }

    private fun sendNotification(title: String, message: String) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, "task_channel")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        notificationManager.notify(1, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "task_channel",
                "Tâches",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications liées aux tâches"
            }
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}
