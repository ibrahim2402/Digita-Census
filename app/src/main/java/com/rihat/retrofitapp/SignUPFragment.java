/********************************************************************************************
 * Copyright (c) 2020. Tahir Raki, Sam Kanjow
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *******************************************************************************************/

package com.rihat.retrofitapp;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rihat.retrofitapp.models.FamilyMember;
import com.rihat.retrofitapp.models.User;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUPFragment extends Fragment {
    private static String TAG = "signUpfragment";

   private EditText fname,lName,email,passord,yearOfbirth,confirm_password, family_member_fname,
            family_member_lname,family_member_phone;

   private Button register_btn;
   private ProgressDialog mprogressDialog;

   private String UserID;



    public SignUPFragment() {
        // Required empty public constructor
    }

    public static SignUPFragment newInstance(){
        return new SignUPFragment();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_u, container, false);
        //initalize all view elements
        fname = view.findViewById(R.id.first_nameText);
        lName = view.findViewById(R.id.last_nameText);
        email = view.findViewById(R.id.emailText);
        passord= view.findViewById(R.id.password_nameText);
        confirm_password = view.findViewById(R.id.confirm_nameText);
        yearOfbirth = view.findViewById(R.id.birth_yearText);

        family_member_fname = view.findViewById(R.id.familyM_first_nameText);
        family_member_lname = view.findViewById(R.id.familyM_last_nameText);
        family_member_phone = view.findViewById(R.id.familyM_poneText);

        register_btn = view.findViewById(R.id.registerAcount_btn);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //Send information to database.(To Main activity).
                registrationData();
            }
        });

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mprogressDialog = new ProgressDialog(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    /**
     * Registration user information.
     *
     *
     */
    public void registrationData(){
        //user info
        String firstName =fname.getText().toString();
        String lastName =lName.getText().toString();
        String emailAdd = email.getText().toString().trim();
        String pass = passord.getText().toString().trim();
        String conFirmPass = confirm_password.getText().toString().trim();
        String year = yearOfbirth.getText().toString().trim();
        //Family member info
        String fm_firstName = family_member_fname.getText().toString();
        String fm_lasttName = family_member_lname.getText().toString();
        String phone = family_member_phone.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(emailAdd).matches()){
            //Set error and focuss to email edittext
            email.setError("Invalid Email");
            email.setFocusable(true);
        }else if(!pass.equalsIgnoreCase(conFirmPass)){
            //set error and foucuse both.
            passord.setError("password miss much");
            passord.setFocusable(true);
            confirm_password.setFocusable(true);
        }else if(phone.length()<10){
            family_member_phone.setError("phone number format error");
            family_member_phone.setFocusable(true);
        } else {
            FamilyMember fm = new FamilyMember(fm_firstName,fm_lasttName,phone);
            User user = new User(firstName,lastName,emailAdd,fm);
            //send
           // TO DO pass user info to create user function
        }

    }

}
