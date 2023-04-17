package com.example.sqlite_ezra

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtname:EditText
    lateinit var edtemail:EditText
    lateinit var edtID:EditText
    lateinit var btnsave:Button
    lateinit var btnview:Button
    lateinit var btndel:Button
    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtname = findViewById(R.id.edt_name)
        edtemail = findViewById(R.id.edt_email)
        edtID = findViewById(R.id.edt_ID)
        btnsave = findViewById(R.id.btn_save)
        btnview = findViewById(R.id.btn_view)
        btndel = findViewById(R.id.btn_del)
        //Create database
        db = openOrCreateDatabase("ezraDB", Context.MODE_PRIVATE, null)
        //create table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(Name VARCHAR, Email VARCHAR, Id VARCHAR)")
        btnsave.setOnClickListener {
            var name_edt = edtname.text.toString().trim()
            var email_edt = edtemail.text.toString().trim()
            var ID_edt = edtID.text.toString().trim()
            //Validate entries
            if (name_edt.isEmpty() || email_edt.isEmpty() || ID_edt.isEmpty()){
                Toast.makeText(this, "Cannot Submit an empty field.", Toast.LENGTH_SHORT).show()
            }else{
                //insert data
                db.execSQL("INSERT INTO users VALUES('\"+name_edt+\"' , '\"+email_edt+\"' ,'\"+ID_edt+\"')")
                Toast.makeText(this, "Data Saved successfully!", Toast.LENGTH_SHORT).show()
            }


        }
        btnview.setOnClickListener {

        }
        btndel.setOnClickListener {

        }
    }
}