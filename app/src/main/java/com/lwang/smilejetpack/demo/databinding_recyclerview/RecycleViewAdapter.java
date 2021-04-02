package com.lwang.smilejetpack.demo.databinding_recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.LayoutRecycleviewItemBinding;
import com.lwang.smilejetpack.demo.databinding.Book;

import java.util.List;

/**
 * @Author lwang
 * @Date 2021/3/31 23:11
 * @Description
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private List<Book> books;


    public RecycleViewAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutRecycleviewItemBinding layoutRecycleviewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_recycleview_item, parent, false);

        return new MyViewHolder(layoutRecycleviewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Book book = books.get(position);
        holder.layoutRecycleviewItemBinding.setBook(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        LayoutRecycleviewItemBinding layoutRecycleviewItemBinding;

        public MyViewHolder(LayoutRecycleviewItemBinding itemView) {

            // getRoot()返回的事布局文件的最外层UI视图
            super(itemView.getRoot());

            layoutRecycleviewItemBinding = itemView;
        }
    }

}
