package com.lwang.smilejetpack.demo.databinding_recyclerview;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.demo.databinding.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lwang
 * @Date 2021/3/31 23:05
 * @Description
 */
public class RecycleViewViewModel {

    public List<Book> getBooks() {

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Book book = new Book("七里香" + i, "周杰伦" + i);
            book.image = R.mipmap.ic_launcher;
            books.add(book);
        }


        return books;
    }

}
