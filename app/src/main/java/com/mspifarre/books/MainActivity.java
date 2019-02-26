package com.mspifarre.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mspifarre.books.model.Book;
import com.mspifarre.books.ws.BooksService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-9d75e-books75.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BooksService service = retrofit.create(BooksService.class);
        Call<List<Book>> books = service.books();

        books.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                for(Book b : response.body() ){
                    Log.d("REST OK", b.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("REST FAIL", t.toString());
            }
        });




    }
}
