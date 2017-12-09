package com.example.devesh.humanresourcemanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sell_goods extends Fragment {

    DatabaseReference my_data;
    Button bt1;
    EditText ed2_P,ed1_N,ed3_D;
    int i;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_sell_goods, container, false);
        bt1 = (Button) view.findViewById(R.id.button2);
        ed1_N = (EditText) view.findViewById(R.id.p_name);
        ed2_P = (EditText) view.findViewById(R.id.P_price);
        ed3_D = (EditText) view.findViewById(R.id.p_details);
        my_data = FirebaseDatabase.getInstance().getReference("goods_to_sell");
        bt1.setOnClickListener(new View.OnClickListener() {

            int k;
            public void onClick(View v) {

                my_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long y = dataSnapshot.getChildrenCount();
                         k = (int) y;
                        return;   }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {  }  });


                String name = ed1_N.getText().toString().trim();
                String price = ed2_P.getText().toString().trim();
                String detail = ed3_D.getText().toString().trim();
                //String id  = my_data.push().getKey();
                goods g1 = new goods(name,price,detail);
                k=k+1;
                String s= String.valueOf(k);
                my_data .child("goods"+s).setValue(g1);
                Toast.makeText(getActivity(),"Data Published",Toast.LENGTH_SHORT).show();

                ed1_N.setText(" ");
                ed2_P.setText(" ");
                ed3_D.setText(" ");

            }
        });
        return  view;
    }


}
