package com.example.sqlite_app

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

     private lateinit var ed_name : EditText
     private lateinit var ed_email : EditText
     private lateinit var ed_ID : EditText
     private lateinit var bt_save: Button
     private lateinit var bt_view: Button
     private lateinit var bt_delete: Button

     private lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_name = findViewById(R.id.edt_name)
        ed_email = findViewById(R.id.edt_email)
        ed_ID = findViewById(R.id.edt_ID)
        bt_delete = findViewById(R.id.btn_delete)
        bt_view = findViewById(R.id.btn_view)
        bt_save = findViewById(R.id.btn_save)

        //creating database
        db = openOrCreateDatabase("ElvisDB", Context.MODE_PRIVATE,null)

        //creating a table
         db.execSQL("CREATE TABLE IF NOT EXISTS users(Jina VARCHAR, arafa VARCHAR,kitambulisho VARCHAR)")

        bt_save.setOnClickListener {
            //Receive data from the user
            var name = ed_name .text.toString()
            var email =  ed_email.text.toString()
            var id_number = ed_ID .text.toString()
            //Check if the user is trying to submit empty records
            if (name.isEmpty() or email.isEmpty() or id_number.isEmpty()){
                //Use the display_message() to Display a message telling the user to fill all the inputs

                Toast.makeText(this, "cannot submit empty field", Toast.LENGTH_SHORT).show()

                //toast a message to say cannot submit empty field


            }else{
                //Proceed to save your data into the db
                db.execSQL("INSERT INTO users VALUES('"+name+"','"+email+"','"+id_number+"')")

                Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show()
                //Toast a success message

            }

        }

    }

   }



