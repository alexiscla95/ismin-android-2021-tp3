package com.ismin.android

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
  var txtTitle = rootView.findViewById<TextView>(R.id.titleId)
  var txtAuthor = rootView.findViewById<TextView>(R.id.authorId)
  var txtDate = rootView.findViewById<TextView>(R.id.dateId)

}