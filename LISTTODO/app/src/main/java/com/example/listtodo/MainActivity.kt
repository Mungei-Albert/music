import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextTask: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listViewTasks: ListView

    private lateinit var tasks: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTask = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)
        listViewTasks = findViewById(R.id.listViewTasks)

        tasks = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        listViewTasks.adapter = adapter

        buttonAdd.setOnClickListener {
            val task = editTextTask.text.toString().trim()
            if (task.isNotEmpty()) {
                tasks.add(task)
                adapter.notifyDataSetChanged()
                editTextTask.text.clear()
            }
        }

        listViewTasks.setOnItemLongClickListener { _, _, position, _ ->
            tasks.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }
    }
}
package com.example.listtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}