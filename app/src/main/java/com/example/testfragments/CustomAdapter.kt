package com.example.testfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter():RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var _userList:List<User> = emptyList()

    fun setUserList(users:List<User>){
        _userList = users
        notifyDataSetChanged()
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView: TextView
        val textViewAge: TextView
        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.textViewItem)
            textViewAge = view.findViewById(R.id.textListViewAge)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return _userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = _userList[position].name
        holder.textViewAge.text = _userList[position].age.toString()
    }
}