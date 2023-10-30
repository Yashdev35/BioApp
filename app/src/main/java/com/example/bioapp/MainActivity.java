package com.example.bioapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.bioapp.data.Bio;
import com.example.bioapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private final Bio bio = new Bio();//this is used for data binding for data . created seperate class in java file and created private variables and then getters and setters and constructor
//    private TextView hobby;
//    private EditText enter_hobbies;as we used data binding for widgets , there is not need for them here
//    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //this to set name that we will se above saved in the bio class and is added in activity.xml
        bio.setName("Yash Vijay Kumbhkarn\'s bio");
        binding.setBio(bio);//this is binding the bio object with widgets
        binding.hobbyButton.setOnClickListener(this::showhobbyMethod);

    }

    public void showhobbyMethod(View view) {
        String givenHobbies = " my hobbies are " + binding.enterYourHobbies.getText().toString().trim();
        //this saves the string hobbies in the bio class and then is added in text view 3 in android.xml file and showen as output
        bio.setHobbies(String.format("hello my name is yash and %s", givenHobbies));
        //binding.textView3.setText(String.format("hello my name is yash and %s", givenHobbies));
        binding.invalidateAll();
        binding.textView3.setVisibility(View.VISIBLE);

//TO HIDE THE KEYBOARD
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}