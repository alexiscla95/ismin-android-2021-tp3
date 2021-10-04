package com.ismin.android
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.EditText


import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismin.androidtp1.Book
import com.ismin.androidtp1.Bookshelf

class MainActivity : AppCompatActivity() {
    private var bookshelf: Bookshelf = Bookshelf()
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newBook = Book("title", "author", "2020")
        val newBook2 = Book("title2", "author", "2020")
        val newBook3 = Book("title3", "author", "2020")
        val newBook4 = Book("title4", "author", "2020")

        bookshelf.addBook(newBook)
        bookshelf.addBook(newBook2)
        bookshelf.addBook(newBook3)
        bookshelf.addBook(newBook4)
        val recyclerView = findViewById<RecyclerView>(R.id.bookRecyclerView)
        adapter = BookAdapter(bookshelf.getAllBooks())
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val someData = result.data?.getSerializableExtra(EXTRA_KEY)
            bookshelf.addBook(someData as Book)
            adapter?.refreshData(bookshelf.getAllBooks())
            adapter?.notifyDataSetChanged()
        }
    }

    fun goToCreation(view: View) {
        val intent = Intent(this, CreateBookActivity::class.java)
        startForResult.launch(intent)
    }


    fun addBook() {

    }
}