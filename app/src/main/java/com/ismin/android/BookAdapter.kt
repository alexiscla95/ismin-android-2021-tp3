package com.ismin.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismin.androidtp1.Book

class BookAdapter(private var books: List<Book>) : RecyclerView.Adapter<BookViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
    val row = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent,
      false)

    return BookViewHolder(row)

  }

  override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    val (title, author, date) = this.books[position]

    holder.txtTitle.text = title
    holder.txtAuthor.text = author
    holder.txtDate.text = date

  }

  override fun getItemCount(): Int {
    return this.books.size
  }

  fun refreshData(books: List<Book>) {
    this.books = books
  }

}