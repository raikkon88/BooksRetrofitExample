# Example retrofit with books

This repository is taken information from apiary test project [Books](https://private-9d75e-books75.apiary-mock.com/books).

## Init this project

Must include the next references in build.gradle.

```{gradle}
implementation 'com.squareup.retrofit2:retrofit:2.5.0'
implementation 'com.squareup.retrofit2:retrofit:2.5.0'
implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
implementation 'com.squareup.okhttp3:okhttp:3.12.0'
implementation 'com.squareup.okhttp3:okhttp-urlconnection:3.11.0'
implementation 'com.squareup.okhttp3:logging-interceptor:3.11.0'
```

Must include INTERNET permissions on android manifest.

```{xml}
<uses-permission android:name="android.permission.INTERNET" />
```

Pay attention to the initialization and usage :

```{java}
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
```