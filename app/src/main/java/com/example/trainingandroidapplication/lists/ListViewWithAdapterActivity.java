package com.example.trainingandroidapplication.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trainingandroidapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewWithAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_adapter);
        ListView listView = findViewById(R.id.listViewWithAdapter);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Последняя одиссея","Джеймс Роллинс"));
        books.add(new Book("Как устроена экономика","Ха-Джун Чанг"));
        books.add(new Book("Sapiens. Краткая история человечества","Юваль Ной Харари"));
        books.add(new Book("Происхождение","Дэн Браун"));
        books.add(new Book("Просто делай! Делай просто!","Оскар Хартманн"));
        BookAdapter bookAdapter =new BookAdapter(books,this);
        listView.setAdapter(bookAdapter);
    }


    class BookAdapter extends BaseAdapter {

        List<Book> bookList;
        LayoutInflater layoutInflater;

        public BookAdapter(List<Book> bookList, Context context) {
            this.bookList = bookList;
            this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return bookList.size();
        }

        @Override
        public Object getItem(int position) {
            return bookList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if(view==null){
                view = layoutInflater.inflate(R.layout.book_item_layout,parent,false);
            }

            Book book = (Book) getItem(position);
            TextView title = view.findViewById(R.id.textViewTitle);
            TextView author = view.findViewById(R.id.textViewAuthor);

            title.setText("Title: "+book.getTitle());
            author.setText("Author: "+book.getAuthor());

            return view;
        }
    }

    class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

    }
}
