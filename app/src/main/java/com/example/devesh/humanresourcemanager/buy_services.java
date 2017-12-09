package com.example.devesh.humanresourcemanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class buy_services extends Fragment {

    DatabaseReference my_data;
    TextView tv1;
    Button bt1,bt2;
    int i =0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_buy_services, container, false);
        // Inflate the layout for this fragment
        bt1 = (Button) view.findViewById(R.id.next_s);
        bt2 = (Button) view.findViewById(R.id.pre_s);
        final TextView tv_name = (TextView) view.findViewById(R.id.bs_name);
        final TextView tv_price = (TextView) view.findViewById(R.id.bs_pice);
        final TextView tv_des = (TextView) view.findViewById(R.id.bs_des);
        final TextView tv_id = (TextView) view.findViewById(R.id.Id_no_s);

        my_data = FirebaseDatabase.getInstance().getReference("Services_to_sell");


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                my_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long y = dataSnapshot.getChildrenCount();
                        int k = (int) y;
                        if (i >= k){ i=0;}

                        String num = String.valueOf(i++);

                        goods x = dataSnapshot.child("servies"+num).getValue(goods.class);
                        tv_name.setText(x.getName());
                        tv_price.setText(x.getPice());
                        tv_des.setText(x.getDescription());
                        tv_id.setText(String.valueOf(k)+','+String.valueOf(i));

                        /*for(DataSnapshot dev : dataSnapshot.getChildren())
                {
                    goods x = dev.getValue(goods.class);
                    System.out.println(x.getName());
                }*/

                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                my_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long y = dataSnapshot.getChildrenCount();
                        int k = (int) y;
                        i=i-1;
                        if(i < 0){i=0;}
                        String num = String.valueOf(i);
                        goods x = dataSnapshot.child("servies"+num).getValue(goods.class);
                        tv_name.setText(x.getName());
                        tv_price.setText(x.getPice());
                        tv_des.setText(x.getDescription());
                        tv_id.setText(String.valueOf(k)+','+String.valueOf(i));

                        /*for(DataSnapshot dev : dataSnapshot.getChildren())
                {
                    goods x = dev.getValue(goods.class);
                    System.out.println(x.getName());
                }*/

                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });


            }
        });





        return view;
    }


}
