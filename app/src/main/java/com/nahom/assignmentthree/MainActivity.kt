package com.nahom.assignmentthree

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tableLayout = findViewById<TableLayout>(R.id.table)
        val addButton = findViewById<Button>(R.id.addBtn)

        addButton.setOnClickListener {
            val nameEditText = findViewById<EditText>(R.id.waterResourceName)
            val locationEditText = findViewById<EditText>(R.id.location)
            val typeEditText = findViewById<EditText>(R.id.type)
            val capacityEditText = findViewById<EditText>(R.id.capacity)

            val name = nameEditText.text.toString()
            val location = locationEditText.text.toString()
            val type = typeEditText.text.toString()
            val capacity = capacityEditText.text.toString()

            if (name.isEmpty() || location.isEmpty() || type.isEmpty() || capacity.isEmpty()) {
                showToast("Please fill in all fields")
            } else {
                val tableRow = TableRow(this)
                val nameTextView = TextView(this)
                val locationTextView = TextView(this)
                val typeTextView = TextView(this)
                val capacityTextView = TextView(this)

                nameTextView.text = name
                locationTextView.text = location
                typeTextView.text = type
                capacityTextView.text = capacity

                tableRow.addView(nameTextView)
                tableRow.addView(locationTextView)
                tableRow.addView(typeTextView)
                tableRow.addView(capacityTextView)

                tableLayout.addView(tableRow)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

