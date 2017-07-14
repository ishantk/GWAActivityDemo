package com.auribises.gwaactivitydemo;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LowerFragment extends Fragment implements View.OnClickListener{


    Button btn;

    Context context;

    public LowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lower, container, false);

        context = getContext();

        btn = view.findViewById(R.id.buttonSubmit);
        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(getActivity(),"Button Clicked",Toast.LENGTH_LONG).show();
//       Toast.makeText(getContext(),"Button Clicked",Toast.LENGTH_LONG).show();
        Toast.makeText(context,"Button Clicked",Toast.LENGTH_LONG).show();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
    }

    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btn = view.findViewById(R.id.buttonSubmit);

    }*/
}
