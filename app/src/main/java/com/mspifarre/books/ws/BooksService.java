package com.mspifarre.books.ws;

import com.mspifarre.books.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BooksService {

    @GET("books")
    Call<List<Book>> books();

}
